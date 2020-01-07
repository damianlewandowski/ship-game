package com.lewandowski;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config
 */
public class Config extends Properties {

  public Config() {
    super();
    try {
      InputStream is = Board.class.getResourceAsStream("/config.properties");
      load(is);
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

}
