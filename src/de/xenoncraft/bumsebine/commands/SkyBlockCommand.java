 package de.xenoncraft.bumsebine.commands;
 
 import de.xenoncraft.bumsebine.main.Variables;
 import java.io.File;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.LinkOption;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.util.HashMap;
 import java.util.UUID;
 import org.apache.commons.io.FileUtils;
 import org.bukkit.Bukkit;
 import org.bukkit.GameMode;
 import org.bukkit.WorldCreator;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 
 public class SkyBlockCommand
   implements CommandExecutor
 {
   private HashMap<Player, Player> invitedplayers = new HashMap<Player, Player>();
   
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
   {
     if ((sender instanceof Player)) {
       Player p = (Player)sender;
       if (args[0].equalsIgnoreCase("teleport"))
       {
         UUID playeruuid = p.getUniqueId();
         String nameofSkyblock = playeruuid + "-skyblockmap";
         Path skyblockpath = Paths.get(playeruuid + "-skyblockmap", new String[0]);
         
         if (Files.exists(skyblockpath, new LinkOption[0]))
         {
           p.sendMessage(Variables.cSkyblockTeleport);
           new WorldCreator(nameofSkyblock).createWorld();
           p.teleport(Bukkit.getWorld(nameofSkyblock).getSpawnLocation().add(0.0D, 1.0D, 0.0D));
         } else {
           p.sendMessage(Variables.cSkyblockNotAvalible);
         }
         p.setGameMode(GameMode.SURVIVAL);
 
 
 
 
 
 
       }
       else if (args[0].equalsIgnoreCase("create")) {
         UUID playeruuid = p.getUniqueId();
         String nameofSkyblock = playeruuid + "-skyblockmap";
         File sourceFile = new File("skyblocktemplate");
         File destinationFile = new File(playeruuid + "-skyblockmap");
         p.sendMessage(Variables.cSkyblockTeleport);
         try {
           FileUtils.copyDirectory(sourceFile, destinationFile);
         } catch (IOException e) {
           p.sendMessage(Variables.cSkyblockalreadyExists);
         }
         new WorldCreator(nameofSkyblock).createWorld();
         p.teleport(Bukkit.getWorld(nameofSkyblock).getSpawnLocation().add(0.0D, 1.0D, 0.0D));
         p.setGameMode(GameMode.SURVIVAL);
 
 
 
 
 
       }
       else if (args[0].equalsIgnoreCase("delete")) {
         UUID playeruuid = p.getUniqueId();
         File deletefile = new File(playeruuid + "-skyblockmap");
         if (deletefile.exists()) {
           try {
             p.teleport(Bukkit.getWorld("Spawn").getSpawnLocation());
             p.setGameMode(GameMode.ADVENTURE);
             Bukkit.getServer().unloadWorld(playeruuid + "-skyblockmap", false);
             FileUtils.deleteDirectory(deletefile);
             p.sendMessage(Variables.cSkyblockSuccelsfullyCreated);
           } catch (IOException e) {
             p.sendMessage(Variables.cSkyblockNotAvalible);
           }
         } else {
           p.sendMessage(Variables.cSkyblockNotAvalible);
         }
         p.setGameMode(GameMode.ADVENTURE);
 
 
 
 
 
       }
       else if (args[0].equalsIgnoreCase("invite")) {
         UUID playeruuid = p.getUniqueId();
         File skyblockFile = new File(playeruuid + "-skyblockmap");
         if (skyblockFile.exists()) {
           if (args.length != 2) {
             p.sendMessage(Variables.cSkyblockpleaseuseinvite);
           } else {
             Player target = Bukkit.getPlayer(args[1]);
             if ((target instanceof Player)) {
               String pname = p.getDisplayName();
               String tname = target.getDisplayName();
               this.invitedplayers.put(p, target);
               p.sendMessage(new String(String.format(Variables.cSkyblockInvitedSender, tname )));
               target.sendMessage(new String(String.format(Variables.cSkyblockInvitedPlayer, pname )));
             } else p.sendMessage(Variables.cSkyblockPlayerOnline);
           }
         }
         else {
           p.sendMessage(Variables.cSkyblockNotAvalible);
           
         }
         
 
 
 
 
 
 
       }
       else if (args[0].equalsIgnoreCase("join")) {
         if (args.length == 2) {
           Player keyp = Bukkit.getPlayer(args[1]);
           if ((invitedplayers.containsKey(keyp)) && (invitedplayers.containsValue(p))) {
             UUID playeruuid = keyp.getUniqueId();
             String nameofSkyblock = playeruuid + "-skyblockmap";
             p.teleport(Bukkit.getWorld(nameofSkyblock).getSpawnLocation().add(0.0D, 1.0D, 0.0D));
             invitedplayers.remove(p);
           } else {
             p.sendMessage(new String(String.format(Variables.cSkyblockNotInvited, args[1] )));
           }
         } else {
           p.sendMessage(Variables.cSkyblockpleaseusejoin);
 
 
         }
         
 
 
 
       }
       else if (args[0].equalsIgnoreCase("help")) {
         p.sendMessage("§6------------------------HELP------------------------");
         p.sendMessage("§6[XenonCraft-Help] §3/skyblock create: Erstellt dein Skyblock!");
         p.sendMessage("§6[XenonCraft-Help] §3/skyblock teleport: Teleportiert dich zu deinem Skyblock!");
         p.sendMessage("§6[XenonCraft-Help] §3/skyblock invite <Spieler>: Lädt einen Spieler zu deinem Skyblock ein!");
         p.sendMessage("§6[XenonCraft-Help] §3/skyblock join: <Spieler>: Damit kommst du zu einem Skyblock von dem du eingeladen wurdest");
         p.sendMessage("§6----------------------------------------------------");
       } else {
    	   p.sendMessage("§6------------------------HELP------------------------");
           p.sendMessage("§6[XenonCraft-Help] §3/skyblock create: Erstellt dein Skyblock!");
           p.sendMessage("§6[XenonCraft-Help] §3/skyblock teleport: Teleportiert dich zu deinem Skyblock!");
           p.sendMessage("§6[XenonCraft-Help] §3/skyblock invite <Spieler>: Lädt einen Spieler zu deinem Skyblock ein!");
           p.sendMessage("§6[XenonCraft-Help] §3/skyblock join: <Spieler>: Damit kommst du zu einem Skyblock von dem du eingeladen wurdest");
           p.sendMessage("§6----------------------------------------------------");  
       }
     }
     
     return false;
   }
 }


