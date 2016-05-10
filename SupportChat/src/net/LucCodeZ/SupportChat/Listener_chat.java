package net.LucCodeZ.SupportChat;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;

public class Listener_chat implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
	    if (COMMAND_support.supporting.containsKey(p))
	    {
	      e.setCancelled(true);
	      Player r = (Player)COMMAND_support.supporting.get(p);
	      p.sendMessage(main.prefix + "§c[§4Staff§c] §e" + p.getName() + "§7: " + e.getMessage());
	      r.sendMessage(main.prefix + "§c[§4Staff§c] §e" +  p.getName() + "§7: " + e.getMessage());
	    }
	    if (COMMAND_support.gettingsupport.containsKey(p))
	    {
	      Player r = (Player)COMMAND_support.gettingsupport.get(p);
	      e.setCancelled(true);
	      p.sendMessage(main.prefix + p.getName() + "§7: " + e.getMessage());
	      r.sendMessage(main.prefix +  p.getName() + "§7: " + e.getMessage());
	    }
		
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory rate = e.getClickedInventory();
		Player staff = COMMAND_support.wirdbewertet.get(p);
		
		if(e.getInventory().getTitle().equals("Bewerte deinen Helfer!")) {
			if(COMMAND_support.inbewertung.contains(p.getName())) {
				if(e.getSlot() == 9 || e.getSlot() == 1 || e.getSlot() == 2 || e.getSlot() == 3 || e.getSlot() == 4 || e.getSlot() == 5 ||
						e.getSlot() == 6 || e.getSlot() == 7 || e.getSlot() == 8 || e.getSlot() == 19 || e.getSlot() == 20 || e.getSlot() == 21
						|| e.getSlot() == 22 || e.getSlot() == 23 || e.getSlot() == 24 || e.getSlot() == 25 || e.getSlot() == 26 || e.getSlot() == 0) {
					e.setCancelled(true);
				}
				
				if(e.getSlot() == 9) {
					
					int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".SehrSchlecht") + 1;
					COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".SehrSchlecht", rating);
					
					p.sendMessage("§6Danke für deine Bewertung!");
					COMMAND_support.inbewertung.remove(p.getName());
					p.closeInventory();
					
					e.setCancelled(true);
					
					try{
						COMMAND_support.cfg.save(COMMAND_support.file);
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
				
				if(e.getSlot() == 10) {
					
					
					
					int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Schlecht") + 1;
					COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Schlecht", rating);
					e.setCancelled(true);
					p.sendMessage("§6Danke für deine Bewertung!");
					COMMAND_support.inbewertung.remove(p.getName());
					p.closeInventory();
					try{
						COMMAND_support.cfg.save(COMMAND_support.file);
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
				
if(e.getSlot() == 11) {
					
					
					
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Meh") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Meh", rating);
					e.setCancelled(true);
					p.sendMessage("§6Danke für deine Bewertung!");
					COMMAND_support.inbewertung.remove(p.getName());
					p.closeInventory();
					try{
						COMMAND_support.cfg.save(COMMAND_support.file);
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}

if(e.getSlot() == 12) {
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Naja") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Naja", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}
if(e.getSlot() == 13) {
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Hmmm") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Hmmm", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}
if(e.getSlot() == 14) {
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Joa") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Joa", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}
if(e.getSlot() == 15) {
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".GanzOk") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".GanzOk", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}
if(e.getSlot() == 16) {
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".Gut") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".Gut", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}
if(e.getSlot() == 17) {
	
	
	
	
	
	
	int rating = COMMAND_support.cfg.getInt("Bewertungen." + staff.getName() + ".SehrGut") + 1;
	COMMAND_support.cfg.set("Bewertungen." + staff.getName() + ".SehrGut", rating);
	e.setCancelled(true);
	p.sendMessage("§6Danke für deine Bewertung!");
	COMMAND_support.inbewertung.remove(p.getName());
	p.closeInventory();
	
	try{
		COMMAND_support.cfg.save(COMMAND_support.file);
	} catch(IOException ex) {
		ex.printStackTrace();
	}
}

			}
		}
	}
	

}
