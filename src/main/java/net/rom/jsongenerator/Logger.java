package net.rom.jsongenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
	  private PrintWriter writer;
	  
	  public Logger() {
	    try {
	      this.writer = new PrintWriter(String.valueOf(JsonGenerator.PATH) + "/log.txt", "UTF-8");
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public void log(String text) {
	    this.writer.println(text);
	    System.out.println(text);
	  }
	  
	  public void end() {
	    this.writer.close();
	  }
	  
	  public void logItem(String name) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String file = String.valueOf(JsonGenerator.PATH) + "output/item/" + name + ".json";
	    log("[" + sdf.format(cal.getTime()) + "] Created Item: " + file);
	  }
	  
	  public void logBlock(String name) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String file = String.valueOf(JsonGenerator.PATH) + "output/block/" + name + ".json";
	    String time = sdf.format(cal.getTime());
	    log("[" + time + "] Created Block: " + file);
	  }
	  
	  public void logBlockstate(String name) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String file = String.valueOf(JsonGenerator.PATH) + "output/blockstate/" + name + ".json";
	    log("[" + sdf.format(cal.getTime()) + "] Created Blockstate: " + file);
	  }
	  
	  public void logRecipe(String name) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String file = String.valueOf(JsonGenerator.PATH) + "output/recipes/" + name + ".json";
	    log("[" + sdf.format(cal.getTime()) + "] Created Recipe: " + file);
	  }
}
