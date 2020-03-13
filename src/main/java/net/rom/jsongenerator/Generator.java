package net.rom.jsongenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.stream.JsonWriter;

import net.rom.jsongenerator.Forge.BlockVarinats;
import net.rom.jsongenerator.Forge.Type;

public class Generator {
	public static void generateItem(String parent) {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value(parent);
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("layer0").value(String.valueOf(JsonGenerator.MODID) + ":items/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.items++;
				JsonGenerator.logger.logItem(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
		JsonGenerator.toGenerate.clear();
	}

	public static void generateItemBlock() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value(String.valueOf(JsonGenerator.MODID) + ":block/" + name);
				writer.name("display");
				writer.beginObject().setIndent("   ");
				writer.name("thirdperson");
				writer.beginObject().setIndent("   ");
				writer.name("rotation");
				writer.beginArray().setIndent("");
				writer.value(10L);
				writer.value(-45L);
				writer.value(170L);
				writer.endArray().setIndent("   ");
				writer.name("translation");
				writer.beginArray().setIndent("");
				writer.value(0L);
				writer.value(1.5D);
				writer.value(-2.75D);
				writer.endArray().setIndent("   ");
				writer.name("scale");
				writer.beginArray().setIndent("");
				writer.value(0.375D);
				writer.value(0.375D);
				writer.value(0.375D);
				writer.endArray().setIndent("   ");
				writer.endObject();
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.items++;
				JsonGenerator.logger.logItem(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateItemBlock(String name) {
		try {
			File file = new File(
					String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/" + name + ".json");
			file.getParentFile().mkdirs();
			JsonWriter writer = new JsonWriter(new FileWriter(file));
			writer.beginObject().setIndent("   ");
			writer.name("parent").value(String.valueOf(JsonGenerator.MODID) + ":block/" + name);
			writer.name("display");
			writer.beginObject().setIndent("   ");
			writer.name("thirdperson");
			writer.beginObject().setIndent("   ");
			writer.name("rotation");
			writer.beginArray().setIndent("");
			writer.value(10L);
			writer.value(-45L);
			writer.value(170L);
			writer.endArray().setIndent("   ");
			writer.name("translation");
			writer.beginArray().setIndent("");
			writer.value(0L);
			writer.value(1.5D);
			writer.value(-2.75D);
			writer.endArray().setIndent("   ");
			writer.name("scale");
			writer.beginArray().setIndent("");
			writer.value(0.375D);
			writer.value(0.375D);
			writer.value(0.375D);
			writer.endArray().setIndent("   ");
			writer.endObject();
			writer.endObject();
			writer.endObject();
			writer.close();
			JsonGenerator.items++;
			JsonGenerator.logger.logItem(name);
		} catch (Exception e) {
			e.printStackTrace();
			JsonGenerator.logger.log(e.toString());
			JsonGenerator.logger.end();
		}
	}

	public static void generateBlock() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/block/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/cube_all");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("all").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
		generateItemBlock();
		generateBlockstate();
		JsonGenerator.toGenerate.clear();
	}

	public static void generateBlockOrientable() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/orientable");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name + "_top");
				writer.name("front").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name + "_front");
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name + "_side");
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
		generateItemBlock();
		generateBlockstateOrientable();
		JsonGenerator.toGenerate.clear();
	}

	public static void generateBlockVariants() {
		for (String name : JsonGenerator.toGenerate) {
			int colon = name.indexOf(":");
			String property = name.substring(colon);
			name = name.replace(property, "");
			property = property.replace(":", "");
			int semicolon = name.indexOf(";");
			String variants = name.substring(semicolon);
			name = name.replace(variants, "");
			variants = variants.replace(";", "");
			String[] variantList = variants.split(",");
			for (int i = 0; i < variantList.length; i++) {
				try {
					File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID
							+ "/models/item/" + name + ".json");
					file.getParentFile().mkdirs();
					JsonWriter writer = new JsonWriter(new FileWriter(file));
					writer.beginObject().setIndent("   ");
					writer.name("parent").value("block/all");
					writer.name("textures");
					writer.beginObject().setIndent("   ");
					writer.name("all").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + variantList[i]);
					writer.endObject();
					writer.endObject();
					writer.close();
					JsonGenerator.blocks++;
					JsonGenerator.logger.logBlock(name);
				} catch (Exception e) {
					e.printStackTrace();
					JsonGenerator.logger.log(e.toString());
					JsonGenerator.logger.end();
				}
				generateItemBlock(variantList[i]);
			}
		}
		generateBlockstateVariants();
		JsonGenerator.toGenerate.clear();
	}

	public static void generateBlockSlab() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/half_slab");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("bottom").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(String.valueOf(name) + "_slab");
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/block/"
						+ name + "_slab_upper.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/upper_slab");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("bottom").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(String.valueOf(name) + "_slab_upper");
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			generateItemBlock(String.valueOf(name) + "_slab");
		}
		generateBlockstateSlab();
		JsonGenerator.toGenerate.clear();
	}

	public static void generateBlockStair() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/item/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/stairs");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("bottom").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(String.valueOf(name) + "_stair");
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/block/"
						+ name + "_stair_inner.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/inner_stairs");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("bottom").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(String.valueOf(name) + "_stair_inner");
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/models/block/"
						+ name + "_stair_outer.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("parent").value("block/outer_stairs");
				writer.name("textures");
				writer.beginObject().setIndent("   ");
				writer.name("bottom").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("top").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.name("side").value(String.valueOf(JsonGenerator.MODID) + ":blocks/" + name);
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blocks++;
				JsonGenerator.logger.logBlock(String.valueOf(name) + "_outer");
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			generateItemBlock(String.valueOf(name) + "_stair");
		}
		generateBlockstateStair();
		JsonGenerator.toGenerate.clear();
	}

	public static void generateBlockstateVariants() {
		for (String name : JsonGenerator.toGenerate) {
			int colon = name.indexOf(":");
			String property = name.substring(colon);
			name = name.replaceFirst(property, "");
			property = property.replace(":", "");
			int semicolon = name.indexOf(";");
			String variants = name.substring(semicolon);
			name = name.replaceFirst(variants, "");
			variants = variants.replace(";", "");
			String[] variantList = variants.split(",");
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				for (int i = 0; i < variantList.length; i++) {
					writer.name(String.valueOf(property) + "=" + variantList[i]);
					writer.beginObject().setIndent("");
					writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + variantList[i]);
					writer.endObject().setIndent("   ");
				}
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateBlockstate() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				writer.name("normal");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.endObject().setIndent("   ");
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateForgeBlockstate() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				ArrayList<String> list = new ArrayList<String>();
				ArrayList<BlockVarinats> bv = new ArrayList<BlockVarinats>();
				ArrayList<Type> ty = new ArrayList<Type>();
				int colon = name.indexOf(":");
				String property = name.substring(colon);
				name = name.replaceFirst(property, "");
				property = property.replace(":", "");
				int semicolon = name.indexOf(";");
				String variants = name.substring(semicolon);
				name = name.replaceFirst(variants, "");
				variants = variants.replace(";", "");
				String[] variantList = variants.split(",");
				list.addAll(Arrays.asList(variantList));
				Arrays.asList(list).forEach(e -> {
					e.stream().forEach(ee -> {
						//);.iterator().forEachRemaining(ee -> {
					
						Type t = new Type(ee);
						ty.add(t);
					});
				});
				;
				BlockVarinats B1 = new BlockVarinats(ty);
				bv.add(B1);
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				OutputStream outputStream = new FileOutputStream(file);
				Forge.writeJsonStream(outputStream, bv);
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateBlockstateSlab() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + "_slab.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				writer.name("half=bottom");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name + "_slab");
				writer.endObject().setIndent("   ");
				writer.name("half=top");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name + "_slab_upper");
				writer.endObject().setIndent("   ");
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + "_slab_double.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				writer.name("normal");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.endObject().setIndent("   ");
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateBlockstateOrientable() {
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + ".json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				writer.name("facing=north");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.endObject().setIndent("   ");
				writer.name("facing=south");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.name("y").value(180L);
				writer.endObject().setIndent("   ");
				writer.name("facing=west");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.name("y").value(270L);
				writer.endObject().setIndent("   ");
				writer.name("facing=east");
				writer.beginObject().setIndent("");
				writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name);
				writer.name("y").value(90L);
				writer.endObject().setIndent("   ");
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}

	public static void generateBlockstateStair() {
		String[] facing = { "east", "south", "west", "north" };
		String[] half = { "bottom", "top" };
		String[] shape = { "straight", "outer_right", "outer_left", "inner_right", "inner_left" };
		for (String name : JsonGenerator.toGenerate) {
			try {
				File file = new File(String.valueOf(JsonGenerator.PATH) + "/" + JsonGenerator.MODID + "/blockstates/"
						+ name + "_stair.json");
				file.getParentFile().mkdirs();
				JsonWriter writer = new JsonWriter(new FileWriter(file));
				writer.beginObject().setIndent("   ");
				writer.name("variants");
				writer.beginObject().setIndent("   ");
				for (int i = 0; i < facing.length; i++) {
					for (int k = 0; k < half.length; k++) {
						for (int j = 0; j < shape.length; j++) {
							writer.name("facing=" + facing[i] + ",half=" + half[k] + ",shape=" + shape[j]);
							writer.beginObject().setIndent("");
							if (shape[j].equals("straight")) {
								writer.name("model").value(String.valueOf(JsonGenerator.MODID) + ":" + name + "_stair");
								writer.name("x").value((k * 180));
								writer.name("y").value((i * 90));
								writer.name("uvlock").value(true);
							} else if (shape[j].equals("inner_right") || shape[j].equals("inner_left")) {
								writer.name("model")
										.value(String.valueOf(JsonGenerator.MODID) + ":" + name + "_stair_inner");
								writer.name("x").value((k * 180));
								if (shape[j].equals("inner_right"))
									writer.name("y").value(((i + k) % 4 * 90));
								if (shape[j].equals("inner_left")) {
									int factor = 0;
									if (k == 0)
										factor = 1;
									if (k == 1)
										factor = 0;
									writer.name("y").value(((i + 3 * factor) % 4 * 90));
								}
								writer.name("uvlock").value(true);
							} else if (shape[j].equals("outer_right") || shape[j].equals("outer_left")) {
								writer.name("model")
										.value(String.valueOf(JsonGenerator.MODID) + ":" + name + "_stair_outer");
								writer.name("x").value((k * 180));
								if (shape[j].equals("outer_right"))
									writer.name("y").value(((i + k) % 4 * 90));
								if (shape[j].equals("outer_left")) {
									int factor = 0;
									if (k == 0)
										factor = 1;
									if (k == 1)
										factor = 0;
									writer.name("y").value(((i + 3 * factor) % 4 * 90));
								}
								writer.name("uvlock").value(true);
							}
							writer.endObject().setIndent("   ");
						}
					}
				}
				writer.endObject();
				writer.endObject();
				writer.close();
				JsonGenerator.blockstates++;
				JsonGenerator.logger.logBlockstate(name);
			} catch (Exception e) {
				e.printStackTrace();
				JsonGenerator.logger.log(e.toString());
				JsonGenerator.logger.end();
			}
		}
	}
}
