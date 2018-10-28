 package de.xenoncraft.bumsebine.listeners;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerQuitEvent;
 
 public class LeaveListener implements Listener
 {
   @EventHandler
   public void onPlayerQuit(PlayerQuitEvent e)
   {
     Player p = e.getPlayer();
     String pname = p.getPlayerListName();
     e.setQuitMessage(new String(String.format(Variables.eQuitMessage, new Object[] { pname })));
   }
 }


