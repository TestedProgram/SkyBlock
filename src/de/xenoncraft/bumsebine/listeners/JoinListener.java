 package de.xenoncraft.bumsebine.listeners;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import org.bukkit.Bukkit;
 import org.bukkit.GameMode;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerJoinEvent;
 
 public class JoinListener
   implements Listener
 {
   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent e)
   {
     Player p = e.getPlayer();
     String pname = p.getPlayerListName();
     e.setJoinMessage(new String(String.format(Variables.eJoinMessage, new Object[] { pname })));
     p.teleport(Bukkit.getWorld("Spawn").getSpawnLocation());
     p.setGameMode(GameMode.ADVENTURE);
   }
 }


