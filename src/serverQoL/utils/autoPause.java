package serverQoL.utils;

import arc.util.Log;
import arc.util.Timer;
import arc.util.Timer.Task;
import mindustry.Vars;
import mindustry.gen.Groups;

public class autoPause {
    public static void checkPlayer() {
        if (Groups.player.size() > 0) {
            Vars.state.serverPaused = false;
        }
    }
    public static void pause(String leave) {
        int player = Groups.player.size();
        switch(leave){
            case "leave":
                if (player -1 < 1) {
                    Vars.state.serverPaused = true;
                    Log.info("[Server-QoL]" + " The game paused automatically after the last player left it");
                }
                break;
            case "join":
                if (player == 1) {
                    Vars.state.serverPaused = false;
                    Log.info("[Server-QoL]" + " The game resumed automatically after a player logged in");
                }
                break;
            case "world":
                if (player < 1) {
                    Vars.state.serverPaused = true;
                    Log.info("[Server-QoL]" + " The game started and paused automatically");
                    Timer.schedule(autoPause::checkPlayer, 1, 2, 2);
                }
                break;
        }
    }
}