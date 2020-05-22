package com.XX.XX.batch.engine.transformer;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class GoEngineTransformerTest {
  static GoCqmTransformer GO_CQM_TRANSFORMER;
  static {
    String os = System.getProperty("os.name").toLowerCase();
    String libExtension;
    if (os.contains("mac os")) {
      libExtension = "dylib";
    } else if (os.contains("windows")) {
      libExtension = "dll";
    } else {
      libExtension = "so";
    }

    String pwd = System.getProperty("user.dir");
    String lib = pwd + "/golang/bin/lib-cqm-transformer." + libExtension;
    GO_CQM_TRANSFORMER = (GoCqmTransformer) Native.loadLibrary(lib, GoCqmTransformer.class);
  }

  public interface GoCqmTransformer extends Library {
    long Add(long x, long y);
  }

  public static void main(String[] args) {
    System.out.println("Java says: about to call Go ..");
    long total = GO_CQM_TRANSFORMER.Add(30, 12);
    System.out.println("Java says: result is " + total);
  }
}