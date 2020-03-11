package net.rom.jsongenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.gson.stream.JsonWriter;

public class Forge {

	public static void writeJsonStream(OutputStream out, List<BlockVarinats> messages) throws IOException {
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
		writer.setIndent("  ");
		writeForgeBlockState(writer, messages);
		writer.close();
	}

	public static void writeForgeBlockState(JsonWriter writer, List<BlockVarinats> messages) throws IOException {
		writer.beginArray();
		for (BlockVarinats message : messages) {
			writeData(writer, message);
		}
		writer.endArray();
	}

	public static void writeData(JsonWriter writer, BlockVarinats message) throws IOException {
		writer.beginObject();
		writer.name("forge_marker").value(1);
		writer.name("defaults");
		writer.beginObject();
		writer.name("model").value("cube_all");
		writer.name("transform").value("forge:default-block");
		writer.endObject();
		writer.name("variants");
		writer.beginObject();
		writer.name("inventory");
		writer.beginArray();
		writer.beginObject();
		writer.endObject();
		writer.endArray();
		writer.name("type");
		writeBlocks(writer, message.getType());
		writer.endObject();
		writer.endObject();
	}

	public static void writeDefault(JsonWriter writer, Defaults defaults) throws IOException {
		writer.beginObject();
		writer.name("model").value(defaults.getName());
		writer.name("transform").value(defaults.getFollowersCount());
		writer.endObject();
	}

	public static void writeBlocks(JsonWriter writer, List<Type> type) throws IOException {
		writer.beginObject();
		for (Type value : type) {
			writer.name(value.getName());
			writer.beginObject();
			writer.name("textures");
			writer.beginObject();
			writer.name("all").value("modid:blocks/" + value.getName());
			writer.endObject();
			writer.endObject();
		}
		writer.endObject();
	}

	public static class Defaults {

		private String model = "cube_all";
		private String transform = "forge:default-block";

		public Defaults() {
		}

		public String getName() {
			return model;
		}

		public String getFollowersCount() {
			return transform;
		}
	}

	public static class Type {
		private String name;

		public Type(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public static class BlockVarinats {

		private List<Type> type;

		public BlockVarinats(List<Type> type) {
			this.type = type;
		}
		
		public List<Type> getType() {
			return type;
		}
	}

}
