 package de.xenoncraft.bumsebine.main;
 
 import java.io.File;
 import org.bukkit.Material;
 
 public class Variables
 {
   public static Material bronzem = Material.CLAY_BRICK;
   public static Material silverm = Material.IRON_INGOT;
   
 
   public static File ordner = new File("./plugins/XenonCraft-Skyblocksystem");
   public static File configf = new File(ordner + "/config");
   
 
 
 
   public static String colorprefix = new String("§3");
   public static String Serverprefix = new String("§6[XenonCraft] ");

   
 
   public static String edeathMessage = new String("has been killed!");
   public static String edeathTeleportMessage = new String(Serverprefix + colorprefix + "You died and will be teleported to the spawn!");
   public static String eMODT = new String(Serverprefix + colorprefix + "SkyBlock Server");
   public static String eQuitMessage = new String(Serverprefix + colorprefix + "%s has left the Server");
   public static String eJoinMessage = new String(Serverprefix + colorprefix + "%s has joined the Server");

   
 
   public static String cSkyblockNotAvalible = new String(Serverprefix + colorprefix + "You don't have a Skyblock.");
   public static String cSkyblockTeleport = new String(Serverprefix + colorprefix + "You are beeing teleported in a few seconds!.");
   public static String cSkyblockalreadyExists = new String(Serverprefix + colorprefix + "You have currently a Skyblock. To delete your Skyblock please use /skyblock delete.");
   public static String cSkyblockpleaseuseinvite = new String(Serverprefix + colorprefix + "Please use /skyblock invite <Player>.");
   public static String cSkyblockpleaseusejoin = new String(Serverprefix + colorprefix + "Please use /skyblock join <Player>.");
   public static String cSkyblockSuccelsfullyCreated = new String(Serverprefix + colorprefix + "Your Skyblock was created successfully!");
   public static String cSkyblockSuccelsfullyDeleted = new String(Serverprefix + colorprefix + "Your Skyblock was deleted successfully!");
   public static String cSkyblockPlayerOnline = new String(Serverprefix + colorprefix + "The player §5%s " + colorprefix + " is not online!");
   public static String cSkyblockInvitedSender = new String(Serverprefix + colorprefix + "You have invited the player §5%s " + colorprefix + "!");
   public static String cSkyblockNotInvited = new String(Serverprefix + colorprefix + "You are not invited to the skyblock of $5%s!");
   public static String cSkyblockInvitedPlayer = new String(Serverprefix + colorprefix + "You have been invited to the Skyblock of §5%s " + colorprefix + "! Use /skyblock join <Player> to join the Skyblock.");
   
 
   public static String cSpawn = new String(Serverprefix + colorprefix + "You are at the Spawn!");
   
 
   public static String cTrashCan = new String("§l§0TrashCan");
   
 
 
 
 
 
 
 
 }


