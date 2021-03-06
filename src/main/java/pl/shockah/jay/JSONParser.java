package pl.shockah.jay;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class JSONParser {
	@Nonnull
	protected String tokenToString(@Nullable Object token) {
		if (token == null)
			return "null";
		else if (token instanceof Boolean)
			return ((Boolean)token) ? "true" : "false";
		else if (token instanceof BigInteger)
			return token.toString();
		else if (token instanceof BigDecimal)
			return token.toString();
		else if (token instanceof String)
			return String.format("'%s'", token);
		else if (token instanceof JSONSpecialToken)
			return ((JSONSpecialToken)token).name();
		else
			throw new UnsupportedOperationException(String.format("Unknown token type: %s", token.getClass().getName()));
	}

	@Nonnull
	public JSONObject parseObject(@Nonnull String json) {
		List<Object> tokens = new JSONTokenizer().tokenize(json);
		TokenBuffer buf = new TokenBuffer(tokens);
		JSONObject j = parseObject(buf);
		if (buf.position < buf.length())
			throw new JSONParseException(String.format("Additional token %s after the ObjectEnd token", tokenToString(buf.get())));
		return j;
	}

	@Nonnull
	public JSONList<Object> parseList(@Nonnull String json) {
		List<Object> tokens = new JSONTokenizer().tokenize(json);
		TokenBuffer buf = new TokenBuffer(tokens);
		JSONList<Object> j = parseList(buf);
		if (buf.position < buf.length())
			throw new JSONParseException(String.format("Additional token %s after the ListEnd token", tokenToString(buf.get())));
		return j;
	}

	@Nonnull
	protected JSONObject parseObject(@Nonnull TokenBuffer buf) {
		JSONObject j = null;
		while (buf.hasLeft()) {
			Object token = buf.get();
			if (j == null) {
				if (token == JSONSpecialToken.ObjectBegin) {
					j = new JSONObject();
				} else {
					throw new JSONParseException(String.format("Invalid token %s; expected ObjectBegin", tokenToString(token)));
				}
			} else {
				if (token == JSONSpecialToken.ObjectEnd) {
					return j;
				} else {
					if (!j.isEmpty()) {
						if (token != JSONSpecialToken.Comma)
							throw new JSONParseException(String.format("Invalid token %s; expected Comma", tokenToString(token)));
						if (buf.hasLeft()) {
							token = buf.get();
						} else {
							throw new JSONParseException("Missing token; expected key token");
						}
					}
					if (token instanceof String) {
						String key = (String)token;
						if (buf.hasLeft()) {
							Object token2 = buf.get();
							if (token2 == JSONSpecialToken.Colon) {
								j.put(key, parseValue(buf));
							} else {
								throw new JSONParseException(String.format("Invalid token %s; expected Colon", tokenToString(token2)));
							}
						} else {
							throw new JSONParseException("Missing token; expected Colon");
						}
					}
				}
			}
		}
		throw new JSONParseException("Missing token; expected ObjectEnd");
	}

	@Nonnull
	protected JSONList<Object> parseList(@Nonnull TokenBuffer buf) {
		JSONList<Object> j = null;
		while (buf.hasLeft()) {
			Object token = buf.get();
			if (j == null) {
				if (token == JSONSpecialToken.ListBegin) {
					j = new JSONList<>();
				} else {
					throw new JSONParseException(String.format("Invalid token %s; expected ListBegin", tokenToString(token)));
				}
			} else {
				if (token == JSONSpecialToken.ListEnd) {
					return j;
				} else {
					if (j.isEmpty()) {
						buf.seek(-1);
					} else {
						if (token != JSONSpecialToken.Comma)
							throw new JSONParseException(String.format("Invalid token %s; expected Comma", tokenToString(token)));
					}
					j.add(parseValue(buf));
				}
			}
		}
		throw new JSONParseException("Missing token; expected ListEnd");
	}

	@Nullable
	protected Object parseValue(@Nonnull TokenBuffer buf) {
		if (!buf.hasLeft())
			throw new JSONParseException("Missing token; expected value token");
		Object token = buf.get();
		if (token instanceof JSONSpecialToken) {
			JSONSpecialToken jsontoken = (JSONSpecialToken)token;
			if (jsontoken == JSONSpecialToken.ObjectBegin) {
				buf.seek(-1);
				return parseObject(buf);
			} else if (jsontoken == JSONSpecialToken.ListBegin) {
				buf.seek(-1);
				return parseList(buf);
			} else {
				throw new JSONParseException(String.format("Invalid token %s; expected value token", tokenToString(token)));
			}
		} else {
			return token;
		}
	}
	
	protected static class TokenBuffer {
		@Nonnull public final List<Object> list;
		public int position = 0;
		
		public TokenBuffer(@Nonnull List<Object> list) {
			this.list = list;
		}
		
		public int length() {
			return list.size();
		}
		
		public int tokensLeft() {
			return list.size() - position;
		}
		
		public boolean hasLeft() {
			return tokensLeft() > 0;
		}
		
		public void seek(int offset) {
			int newPosition = position + offset;
			if (newPosition < 0 || newPosition > list.size())
				throw new IndexOutOfBoundsException();
			position = newPosition;
		}
		
		public void seekTo(int position) {
			if (position < 0 || position > list.size())
				throw new IndexOutOfBoundsException();
			this.position = position;
		}

		@Nullable
		public Object get() {
			if (position >= list.size())
				throw new IndexOutOfBoundsException();
			return list.get(position++);
		}
	}
}