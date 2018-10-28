 package de.xenoncraft.bumsebine.listeners;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import net.minecraft.server.v1_12_R1.PacketPlayInClientCommand;
 import org.bukkit.GameMode;
 import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.entity.PlayerDeathEvent;
 
 public class DeathListener implements org.bukkit.event.Listener
 {
   @EventHandler
   public void OnPlayerDeath(PlayerDeathEvent e)
   {
     Player p = e.getEntity();
     ((CraftPlayer)p).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
     p.teleport(org.bukkit.Bukkit.getWorld("Spawn").getSpawnLocation());
     p.sendMessage(Variables.edeathTeleportMessage);
     p.setGameMode(GameMode.ADVENTURE);
     e.setDeathMessage(Variables.colorprefix + p + Variables.edeathMessage);
   }
 }


