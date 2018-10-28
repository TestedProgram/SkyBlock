 package de.xenoncraft.bumsebine.commands;
 
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.bukkit.inventory.Inventory;
 
 public class TrashCommand implements CommandExecutor
 {
   public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
   {
     if ((sender instanceof Player)) {
       Player p = (Player)sender;
       if (args.length == 0) {
         int invSize = 54;
         Inventory trashcan = Bukkit.createInventory(null, invSize, "§l§0Mülleimer");
         p.openInventory(trashcan);
       }
     }
     return false;
   }
 }


