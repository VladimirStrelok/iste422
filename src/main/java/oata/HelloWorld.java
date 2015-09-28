package oata;

// Import log4j classes.
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;

public class HelloWorld {
  private static final Logger LOG = LogManager.getLogger(HelloWorld.class);

  public static void main(String[] args) {
    String w = null;
    try {
      w = causeError2();
    }
    catch (Exception e) {
      System.err.println("There was a problem!");
    }
    try {
      causeError2();
    }
    catch (Exception e) {
      System.err.println("There was a problem!\nPlease fix the code");
    }
    LOG.info(w);
  }

  public static String readFile(InputStream fs) throws IOException {
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    String line;
    br = new BufferedReader(new InputStreamReader(fs));
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    
    return sb.toString();
  }
  public static String causeError2() throws IOException {
    StringBuilder sb = new StringBuilder();
    try{
      InputStream fs = HelloWorld.class.getClassLoader().getResourceAsStream("myfile");
      sb.append(readFile(fs));
    }
    catch (Exception e) {
      e.printStackTrace();
      System.err.println("I caught a problem");
      throw e;
    }
    return sb.toString();
  }
}
