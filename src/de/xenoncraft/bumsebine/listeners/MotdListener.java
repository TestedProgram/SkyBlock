 package de.xenoncraft.bumsebine.listeners;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.server.ServerListPingEvent;
 
 public class MotdListener
   implements Listener
 {
   @EventHandler
   public void onPing(ServerListPingEvent e)
   {
     e.setMotd(Variables.eMODT);
   }
 }


