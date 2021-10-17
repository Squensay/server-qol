package serverQoL;

import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Plugin;
import serverQoL.utils.autoPause;
import serverQoL.utils.resetSave;


public class ServerQoL extends Plugin {
    @Override
    public void init(){
        Events.on(EventType.PlayerLeave.class, event -> autoPause.pause("leave"));
        Events.on(EventType.PlayerJoin.class, event -> autoPause.pause("join"));
        Events.on(EventType.WorldLoadEvent.class, event -> autoPause.pause("world"));
        Events.on(EventType.GameOverEvent.class, event -> resetSave.delSave());
    }
}
