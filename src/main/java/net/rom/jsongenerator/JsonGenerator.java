package net.rom.jsongenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.ArrayList;

public class JsonGenerator {
	public static ArrayList<String> toGenerate = new ArrayList<>();
	public static String MODID;
	public static String PATH;
	public static final String VERSION = "0.0.1";
	public static int blockstates = 0;
	public static int blocks = 0;
	public static int items = 0;
	public static int recipes = 0;
	public static Logger logger;

	public static void main(String[] args) throws IOException {
		try {
			PATH = JsonGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()
					.replace("JsonGenerator-" + VERSION + ".jar", "");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		logger = new Logger();
		firstRun();
		readModid();
		if (MODID == null) {
			UnsupportedOperationException ex = new UnsupportedOperationException("modid.txt cannot be empty!");
			logger.log(ex.toString());
			logger.end();
			throw ex;
		}
		readToGenerateFile("item");
		Generator.generateItem("item/generated");
		readToGenerateFile("handheld");
		Generator.generateItem("item/handheld");
		readToGenerateFile("block");
		Generator.generateBlock();
		readToGenerateFile("forge_block");
		Generator.generateForgeBlockstate();
		readToGenerateFile("orientable");
		Generator.generateBlockOrientable();
		readToGenerateFile("variant");
		Generator.generateBlockVariants();
		readToGenerateFile("slab");
		Generator.generateBlockSlab();
		readToGenerateFile("stair");
		Generator.generateBlockStair();
		end();
	}

	public static void firstRun() throws IOException {
		PrintWriter log = new PrintWriter(String.valueOf(PATH) + "/log.txt", "UTF-8");
		log.print("");
		log.close();
		File params = new File(String.valueOf(PATH) + "/params/");
		params.mkdir();
		File items = new File(String.valueOf(PATH) + "/params/item.txt");
		items.createNewFile();
		File forgeBlock = new File(String.valueOf(PATH) + "/params/forge_block.txt");
		forgeBlock.createNewFile();
		File blocks = new File(String.valueOf(PATH) + "/params/block.txt");
		blocks.createNewFile();
		File handheld = new File(String.valueOf(PATH) + "/params/handheld.txt");
		handheld.createNewFile();
		File orientable = new File(String.valueOf(PATH) + "/params/orientable.txt");
		orientable.createNewFile();
		File variant = new File(String.valueOf(PATH) + "/params/variant.txt");
		variant.createNewFile();
		File slab = new File(String.valueOf(PATH) + "/params/slab.txt");
		slab.createNewFile();
		File stair = new File(String.valueOf(PATH) + "/params/stair.txt");
		stair.createNewFile();
		File modid = new File(String.valueOf(PATH) + "/modid.txt");
		modid.createNewFile();

	}

	public static void readModid() {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(String.valueOf(PATH) + "/modid.txt");
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(String.valueOf(PATH) + "/modid.txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null)
				MODID = sCurrentLine;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void readToGenerateFile(String type) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(String.valueOf(PATH) + "/params/" + type + ".txt");
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(String.valueOf(PATH) + "/params/" + type + ".txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null)
				toGenerate.add(sCurrentLine);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void end() {
		logger.log("END");
		logger.log("Created " + blocks + " Block Model Files");
		logger.log("Created " + items + " Item Model Files");
		logger.log("Created " + blockstates + " Blockstate Files");
		logger.log("Created " + recipes + " Recipe Files");
		logger.end();
	}

}
