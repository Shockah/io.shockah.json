package pl.shockah.json;

import pl.shockah.util.func.Action0;
import pl.shockah.util.func.Action1;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class JSONPath {
	public final JSONObject json;
	
	public JSONPath(JSONObject json) {
		this.json = json;
	}
	
	protected static String[] splitPath(String path) {
		return path.split("\\.");
	}

	public boolean getBool(String path) {
		return getBool(splitPath(path));
	}
	
	public boolean getBool(String path, boolean def) {
		return getBool(splitPath(path), def);
	}

	@Nullable
	public Boolean getOptionalBool(String path) {
		return getOptionalBool(splitPath(path));
	}
	
	public void onBool(String path, Action1<Boolean> f) {
		onBool(splitPath(path), f);
	}

	public void onBool(String path, Action1<Boolean> f, Action0 orElse) {
		onBool(splitPath(path), f, orElse);
	}
	
	protected boolean getBool(String[] path) {
		if (path.length == 1)
			return json.getBool(path[0]);
		return new JSONPath(json.getObject(path[0])).getBool(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected boolean getBool(String[] path, boolean def) {
		if (path.length == 1)
			return json.getBool(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getBool(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected Boolean getOptionalBool(String[] path) {
		if (path.length == 1)
			return json.getOptionalBool(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalBool(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onBool(String[] path, Action1<Boolean> f) {
		if (path.length == 1)
			json.onBool(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onBool(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onBool(String[] path, Action1<Boolean> f, Action0 orElse) {
		if (path.length == 1)
			json.onBool(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onBool(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}

	@Nonnull
	public BigInteger getBigInt(String path) {
		return getBigInt(splitPath(path));
	}

	@Nonnull
	public BigInteger getBigInt(String path, BigInteger def) {
		return getBigInt(splitPath(path), def);
	}

	@Nullable
	public BigInteger getOptionalBigInt(String path) {
		return getOptionalBigInt(splitPath(path));
	}
	
	public void onBigInt(String path, Action1<BigInteger> f) {
		onBigInt(splitPath(path), f);
	}

	public void onBigInt(String path, Action1<BigInteger> f, Action0 orElse) {
		onBigInt(splitPath(path), f, orElse);
	}

	@Nonnull
	protected BigInteger getBigInt(String[] path) {
		if (path.length == 1)
			return json.getBigInt(path[0]);
		return new JSONPath(json.getObject(path[0])).getBigInt(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected BigInteger getBigInt(String[] path, BigInteger def) {
		if (path.length == 1)
			return json.getBigInt(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getBigInt(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected BigInteger getOptionalBigInt(String[] path) {
		if (path.length == 1)
			return json.getOptionalBigInt(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalBigInt(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onBigInt(String[] path, Action1<BigInteger> f) {
		if (path.length == 1)
			json.onBigInt(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onBigInt(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onBigInt(String[] path, Action1<BigInteger> f, Action0 orElse) {
		if (path.length == 1)
			json.onBigInt(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onBigInt(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}
	
	public int getInt(String path) {
		return getInt(splitPath(path));
	}
	
	public int getInt(String path, int def) {
		return getInt(splitPath(path), def);
	}

	@Nullable
	public Integer getOptionalInt(String path) {
		return getOptionalInt(splitPath(path));
	}
	
	public void onInt(String path, Action1<Integer> f) {
		onInt(splitPath(path), f);
	}

	public void onInt(String path, Action1<Integer> f, Action0 orElse) {
		onInt(splitPath(path), f, orElse);
	}
	
	protected int getInt(String[] path) {
		if (path.length == 1)
			return json.getInt(path[0]);
		return new JSONPath(json.getObject(path[0])).getInt(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected int getInt(String[] path, int def) {
		if (path.length == 1)
			return json.getInt(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getInt(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected Integer getOptionalInt(String[] path) {
		if (path.length == 1)
			return json.getOptionalInt(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalInt(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onInt(String[] path, Action1<Integer> f) {
		if (path.length == 1)
			json.onInt(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onInt(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onInt(String[] path, Action1<Integer> f, Action0 orElse) {
		if (path.length == 1)
			json.onInt(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onInt(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}
	
	public long getLong(String path) {
		return getLong(splitPath(path));
	}
	
	public long getLong(String path, long def) {
		return getLong(splitPath(path), def);
	}

	@Nullable
	public Long getOptionalLong(String path) {
		return getOptionalLong(splitPath(path));
	}
	
	public void onLong(String path, Action1<Long> f) {
		onLong(splitPath(path), f);
	}

	public void onLong(String path, Action1<Long> f, Action0 orElse) {
		onLong(splitPath(path), f, orElse);
	}
	
	protected long getLong(String[] path) {
		if (path.length == 1)
			return json.getLong(path[0]);
		return new JSONPath(json.getObject(path[0])).getLong(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected long getLong(String[] path, long def) {
		if (path.length == 1)
			return json.getLong(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getLong(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected Long getOptionalLong(String[] path) {
		if (path.length == 1)
			return json.getOptionalLong(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalLong(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onLong(String[] path, Action1<Long> f) {
		if (path.length == 1)
			json.onLong(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onLong(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onLong(String[] path, Action1<Long> f, Action0 orElse) {
		if (path.length == 1)
			json.onLong(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onLong(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}

	@Nonnull
	public BigDecimal getBigDecimal(String path) {
		return getBigDecimal(splitPath(path));
	}

	@Nonnull
	public BigDecimal getBigDecimal(String path, BigDecimal def) {
		return getBigDecimal(splitPath(path), def);
	}

	@Nullable
	public BigDecimal getOptionalBigDecimal(String path) {
		return getOptionalBigDecimal(splitPath(path));
	}
	
	public void onBigDecimal(String path, Action1<BigDecimal> f) {
		onBigDecimal(splitPath(path), f);
	}

	public void onBigDecimal(String path, Action1<BigDecimal> f, Action0 orElse) {
		onBigDecimal(splitPath(path), f, orElse);
	}

	@Nonnull
	protected BigDecimal getBigDecimal(String[] path) {
		if (path.length == 1)
			return json.getBigDecimal(path[0]);
		return new JSONPath(json.getObject(path[0])).getBigDecimal(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected BigDecimal getBigDecimal(String[] path, BigDecimal def) {
		if (path.length == 1)
			return json.getBigDecimal(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getBigDecimal(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected BigDecimal getOptionalBigDecimal(String[] path) {
		if (path.length == 1)
			return json.getOptionalBigDecimal(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalBigDecimal(Arrays.copyOfRange(path, 1, path.length));
	}

	protected void onBigDecimal(String[] path, Action1<BigDecimal> f) {
		if (path.length == 1)
			json.onBigDecimal(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onBigDecimal(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onBigDecimal(String[] path, Action1<BigDecimal> f, Action0 orElse) {
		if (path.length == 1)
			json.onBigDecimal(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onBigDecimal(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}
	
	public float getFloat(String path) {
		return getFloat(splitPath(path));
	}
	
	public float getFloat(String path, float def) {
		return getFloat(splitPath(path), def);
	}

	@Nullable
	public Float getOptionalFloat(String path) {
		return getOptionalFloat(splitPath(path));
	}
	
	public void onFloat(String path, Action1<Float> f) {
		onFloat(splitPath(path), f);
	}

	public void onFloat(String path, Action1<Float> f, Action0 orElse) {
		onFloat(splitPath(path), f, orElse);
	}
	
	protected float getFloat(String[] path) {
		if (path.length == 1)
			return json.getFloat(path[0]);
		return new JSONPath(json.getObject(path[0])).getFloat(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected float getFloat(String[] path, float def) {
		if (path.length == 1)
			return json.getFloat(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getFloat(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected Float getOptionalFloat(String[] path) {
		if (path.length == 1)
			return json.getOptionalFloat(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalFloat(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onFloat(String[] path, Action1<Float> f) {
		if (path.length == 1)
			json.onFloat(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onFloat(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onFloat(String[] path, Action1<Float> f, Action0 orElse) {
		if (path.length == 1)
			json.onFloat(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onFloat(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}
	
	public double getDouble(String path) {
		return getDouble(splitPath(path));
	}
	
	public double getDouble(String path, double def) {
		return getDouble(splitPath(path), def);
	}

	@Nullable
	public Double getOptionalDouble(String path) {
		return getOptionalDouble(splitPath(path));
	}
	
	public void onDouble(String path, Action1<Double> f) {
		onDouble(splitPath(path), f);
	}

	public void onDouble(String path, Action1<Double> f, Action0 orElse) {
		onDouble(splitPath(path), f, orElse);
	}
	
	protected double getDouble(String[] path) {
		if (path.length == 1)
			return json.getDouble(path[0]);
		return new JSONPath(json.getObject(path[0])).getDouble(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected double getDouble(String[] path, double def) {
		if (path.length == 1)
			return json.getDouble(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getDouble(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected Double getOptionalDouble(String[] path) {
		if (path.length == 1)
			return json.getOptionalDouble(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalDouble(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onDouble(String[] path, Action1<Double> f) {
		if (path.length == 1)
			json.onDouble(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onDouble(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onDouble(String[] path, Action1<Double> f, Action0 orElse) {
		if (path.length == 1)
			json.onDouble(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onDouble(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}

	@Nonnull
	public String getString(String path) {
		return getString(splitPath(path));
	}

	@Nonnull
	public String getString(String path, String def) {
		return getString(splitPath(path), def);
	}

	@Nullable
	public String getOptionalString(String path) {
		return getOptionalString(splitPath(path));
	}
	
	public void onString(String path, Action1<String> f) {
		onString(splitPath(path), f);
	}

	public void onString(String path, Action1<String> f, Action0 orElse) {
		onString(splitPath(path), f, orElse);
	}

	@Nonnull
	protected String getString(String[] path) {
		if (path.length == 1)
			return json.getString(path[0]);
		return new JSONPath(json.getObject(path[0])).getString(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected String getString(String[] path, String def) {
		if (path.length == 1)
			return json.getString(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getString(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nullable
	protected String getOptionalString(String[] path) {
		if (path.length == 1)
			return json.getOptionalString(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalString(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onString(String[] path, Action1<String> f) {
		if (path.length == 1)
			json.onString(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onString(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onString(String[] path, Action1<String> f, Action0 orElse) {
		if (path.length == 1)
			json.onString(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onString(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}

	@Nonnull
	public JSONObject getObject(String path) {
		return getObject(splitPath(path));
	}

	@Nonnull
	public JSONObject getObject(String path, JSONObject def) {
		return getObject(splitPath(path), def);
	}

	@Nonnull
	public JSONObject getObjectOrEmpty(String path) {
		return getObjectOrEmpty(splitPath(path));
	}

	@Nonnull
	public JSONObject getObjectOrNew(String path) {
		return getObjectOrNew(splitPath(path));
	}

	@Nullable
	public JSONObject getOptionalObject(String path) {
		return getOptionalObject(splitPath(path));
	}
	
	public void onObject(String path, Action1<JSONObject> f) {
		onObject(splitPath(path), f);
	}

	public void onObject(String path, Action1<JSONObject> f, Action0 orElse) {
		onObject(splitPath(path), f, orElse);
	}

	@Nonnull
	protected JSONObject getObject(String[] path) {
		if (path.length == 1)
			return json.getObject(path[0]);
		return new JSONPath(json.getObject(path[0])).getObject(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected JSONObject getObject(String[] path, JSONObject def) {
		if (path.length == 1)
			return json.getObject(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getObject(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nonnull
	protected JSONObject getObjectOrEmpty(String[] path) {
		if (path.length == 1)
			return json.getObjectOrEmpty(path[0]);
		if (!json.containsKey(path[0]))
			return new JSONObject();
		return new JSONPath(json.getObject(path[0])).getObjectOrEmpty(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected JSONObject getObjectOrNew(String[] path) {
		if (path.length == 1)
			return json.getObjectOrNew(path[0]);
		if (!json.containsKey(path[0]))
			json.put(path[0], new JSONObject());
		return new JSONPath(json.getObject(path[0])).getObjectOrNew(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nullable
	protected JSONObject getOptionalObject(String[] path) {
		if (path.length == 1)
			return json.getOptionalObject(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalObject(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onObject(String[] path, Action1<JSONObject> f) {
		if (path.length == 1)
			json.onObject(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onObject(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onObject(String[] path, Action1<JSONObject> f, Action0 orElse) {
		if (path.length == 1)
			json.onObject(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onObject(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}

	@Nonnull
	public JSONList<?> getList(String path) {
		return getList(splitPath(path));
	}

	@Nonnull
	public JSONList<?> getList(String path, JSONList<?> def) {
		return getList(splitPath(path), def);
	}

	@Nonnull
	public JSONList<?> getListOrEmpty(String path) {
		return getListOrEmpty(splitPath(path));
	}

	@Nonnull
	public JSONList<?> getListOrNew(String path) {
		return getListOrNew(splitPath(path));
	}

	@Nullable
	public JSONList<?> getOptionalList(String path) {
		return getOptionalList(splitPath(path));
	}
	
	public void onList(String path, Action1<JSONList<?>> f) {
		onList(splitPath(path), f);
	}

	public void onList(String path, Action1<JSONList<?>> f, Action0 orElse) {
		onList(splitPath(path), f, orElse);
	}

	@Nonnull
	protected JSONList<?> getList(String[] path) {
		if (path.length == 1)
			return json.getList(path[0]);
		return new JSONPath(json.getObject(path[0])).getList(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected JSONList<?> getList(String[] path, JSONList<?> def) {
		if (path.length == 1)
			return json.getList(path[0], def);
		if (!json.containsKey(path[0]))
			return def;
		return new JSONPath(json.getObject(path[0])).getList(Arrays.copyOfRange(path, 1, path.length), def);
	}

	@Nonnull
	protected JSONList<?> getListOrEmpty(String[] path) {
		if (path.length == 1)
			return json.getListOrEmpty(path[0]);
		if (!json.containsKey(path[0]))
			return new JSONList<>();
		return new JSONPath(json.getObject(path[0])).getListOrEmpty(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	protected JSONList<?> getListOrNew(String[] path) {
		if (path.length == 1)
			return json.getListOrNew(path[0]);
		if (!json.containsKey(path[0]))
			json.put(path[0], new JSONList<>());
		return new JSONPath(json.getObject(path[0])).getListOrNew(Arrays.copyOfRange(path, 1, path.length));
	}

	@Nullable
	protected JSONList<?> getOptionalList(String[] path) {
		if (path.length == 1)
			return json.getOptionalList(path[0]);
		return new JSONPath(json.getObject(path[0])).getOptionalList(Arrays.copyOfRange(path, 1, path.length));
	}
	
	protected void onList(String[] path, Action1<JSONList<?>> f) {
		if (path.length == 1)
			json.onList(path[0], f);
		else
			new JSONPath(json.getObject(path[0])).onList(Arrays.copyOfRange(path, 1, path.length), f);
	}

	protected void onList(String[] path, Action1<JSONList<?>> f, Action0 orElse) {
		if (path.length == 1)
			json.onList(path[0], f, orElse);
		else
			new JSONPath(json.getObject(path[0])).onList(Arrays.copyOfRange(path, 1, path.length), f, orElse);
	}
	
	public void put(String path, Object value) {
		value = JSONObject.prepareObject(value);
		put(splitPath(path), value);
	}
	
	protected void put(String[] path, Object value) {
		if (path.length == 1)
			json.put(path[0], value);
		else
			new JSONPath(json.getObjectOrNew(path[0])).put(Arrays.copyOfRange(path, 1, path.length), value);
	}
}