 package de.xenoncraft.bumsebine.commands;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import org.bukkit.Bukkit;
 import org.bukkit.GameMode;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 
 public class SpawnCommand implements CommandExecutor
 {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
   {
     if ((sender instanceof Player)) {
       Player p = (Player)sender;
       p.teleport(Bukkit.getWorld("Spawn").getSpawnLocation());
       p.sendMessage(Variables.cSpawn);
       p.setGameMode(GameMode.ADVENTURE);
     }
     return false;
   }
 }


