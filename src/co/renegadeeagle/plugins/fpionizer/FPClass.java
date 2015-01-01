package co.renegadeeagle.plugins.fpionizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class FPClass extends JavaPlugin implements Listener {
	//This is an FP Single Comment

	public void onEnable() {	
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler (priority  = EventPriority.LOWEST)
	public void onPlayerPreProcessCommand(PlayerCommandPreprocessEvent event) {
		if(event.getMessage().equalsIgnoreCase("/pl") || event.getMessage().equalsIgnoreCase("/plugins")) {
			String pluginsString = "Plugins (" + Bukkit.getPluginManager().getPlugins().length + "): ";
			event.setCancelled(true);

			List<Plugin> plugins = new ArrayList<Plugin>(Arrays.asList(Bukkit.getPluginManager().getPlugins()));
			System.out.println(plugins);
			for(int index = 1; index < plugins.size(); index++) {
				Plugin current = plugins.get(index);
				
				if(index != (plugins.size()-1)) {
					pluginsString += ChatColor.GREEN + "FP" + current.getName() + ChatColor.WHITE + ", ";
				} else {
					pluginsString += ChatColor.GREEN + "FP" + current.getName();
				}
			}
			event.getPlayer().sendMessage(pluginsString);
		}
	}
}
