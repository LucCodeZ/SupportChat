package net.LucCodeZ.SupportChat;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public static final String prefix = "§7[§6Support-Chat§7] §3";
	
	
	@Override
	public void onEnable() {
	this.getCommand("support").setExecutor(new COMMAND_support());
	
	this.getServer().getPluginManager().registerEvents(new Listener_chat(), this);
	
	this.getServer().getPluginManager().registerEvents(new COMMAND_support(), this);
	
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
	}
	
	@Override
	public void onDisable() {
		try{
			COMMAND_support.cfg.save(COMMAND_support.file);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
