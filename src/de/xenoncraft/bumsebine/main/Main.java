 package de.xenoncraft.bumsebine.main;
 

 import de.xenoncraft.bumsebine.commands.SkyBlockCommand;
 import de.xenoncraft.bumsebine.commands.SpawnCommand;
 import de.xenoncraft.bumsebine.commands.TrashCommand;
 import de.xenoncraft.bumsebine.listeners.DeathListener;
 import de.xenoncraft.bumsebine.listeners.JoinListener;
 import de.xenoncraft.bumsebine.listeners.LeaveListener;
 import de.xenoncraft.bumsebine.listeners.MotdListener;
 import org.bukkit.Bukkit;
 import org.bukkit.Difficulty;
 import org.bukkit.WorldCreator;
 import org.bukkit.plugin.PluginManager;
 import org.bukkit.plugin.java.JavaPlugin;
 
 public class Main extends JavaPlugin
 {
   private static Main plugin;
   
 
   
   
 
 
   public void onEnable() {
     plugin = this;
     
     getCommand("skyblock").setExecutor(new SkyBlockCommand());
     getCommand("trash").setExecutor(new TrashCommand());
     
 
 
     getCommand("spawn").setExecutor(new SpawnCommand());
     getCommand("hub").setExecutor(new SpawnCommand());
     getCommand("lobby").setExecutor(new SpawnCommand());
     
 
     Bukkit.createWorld(new WorldCreator("Spawn"));
     
 
     Variables.ordner.mkdirs();
     
 
     Bukkit.getWorld("Spawn").setDifficulty(Difficulty.PEACEFUL);
     
 
     PluginManager pm = Bukkit.getPluginManager();
     
     pm.registerEvents(new JoinListener(), this);
     pm.registerEvents(new LeaveListener(), this);
     pm.registerEvents(new MotdListener(), this);
     pm.registerEvents(new DeathListener(), this);
   }
   
 
   public void onDisable() {
	   
   }
   
public static Main getPlugin() {
	return plugin; 
	}
}