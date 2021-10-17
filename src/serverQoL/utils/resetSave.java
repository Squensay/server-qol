package serverQoL.utils;

import arc.util.Log;
import mindustry.Vars;
import rhino.EcmaError;

import java.io.File;
import java.util.Objects;

public class resetSave {
    public static void checkSaveFolder() {
        try {
            File check = new File("config/QoL-saves");
            if (!check.exists() && !check.isDirectory()) {
                check.mkdir();
            }
        } catch(Exception e) {
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
            Log.warn("[Server-QoL] " + " no save files");
        }
    }
}
