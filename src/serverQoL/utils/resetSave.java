package serverQoL.utils;

import arc.util.Log;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class resetSave {
    public static void checkSaveFolder() {
        try {
            File check = new File("config/QoL-saves");
            if (!check.exists() && !check.isDirectory()) {
                check.mkdir();
            }
        } catch (Exception e) {
            Log.warn("[Server-QoL]" + " cannot create save folder");
        }
    }

    public static void delSave() {
        checkSaveFolder();
        try {
            File del = new File("config/saves/");
            for (File file : Objects.requireNonNull(del.listFiles())) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            Log.warn("[Server-QoL] " + " no save file to delete in saves folder");
        }
    }

    public static void delQoLSave() {
        checkSaveFolder();
        try {
            File del = new File("config/QoL-saves/");
            for (File file : Objects.requireNonNull(del.listFiles())) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            Log.warn("[Server-QoL] " + " no save file to delete in QoL backup saves folder");
        }
    }
    public static void mvSave() {
        delQoLSave();
        try {
            File mv = new File("config/saves/");
            for (File file : Objects.requireNonNull(mv.listFiles())) {
                if (!file.isDirectory()) {

                }
            }
            delSave();
        } catch (Exception e) {
            Log.warn("[Server-QoL] " + " no save files to move");
        }
    }
}
