package net.LucCodeZ.SupportChat;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class COMMAND_support implements CommandExecutor, Listener {
	
	
	public static HashMap<Player, Player> supporting = new HashMap<Player, Player>();
	
	public static HashMap<Player, Player> gettingsupport = new HashMap<Player, Player>();
	
	public static ArrayList<String> inrequest = new ArrayList<>();
	
	public static ArrayList<String> insupport = new ArrayList<String>();
	
	public static ArrayList<String> inbewertung = new ArrayList<String>();
	
	public static HashMap <Player, Player> wirdbewertet = new HashMap<>();
	
	
	public static File file = new File("plugins//SupportChat//StaffBewertungen.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(args.length == 0) {
			p.sendMessage("");
			p.sendMessage("               " + main.prefix);
			p.sendMessage("               §e/support request");
			p.sendMessage("");
			return true;
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("request")) {
				inrequest.add(p.getName());
				for(Player staff : Bukkit.getOnlinePlayers()) {
					if(staff.hasPermission("supportchat.receive")) {
						staff.sendMessage(main.prefix + "Der Spieler §2" + p.getName() + " §3benötigt Hilfe!");
					}
				}
			}
			
			if(args[0].equalsIgnoreCase("close")) {
				if(p.hasPermission("supportchat.close")) {
					
					Player needhelp = supporting.get(p);
					Player staff = gettingsupport.get(needhelp);
					
					if(supporting.containsKey(p)) {
						p.sendMessage(main.prefix + "Du hast den Support-Chat beendet!");
						needhelp.sendMessage(main.prefix + staff.getName() + " hat den Support-Chat beendet!");
						
						gettingsupport.remove(needhelp);
						supporting.remove(p);
						
						
							
						insupport.remove(p.getName());
						insupport.remove(needhelp.getName());
						
						wirdbewertet.put(needhelp, staff);
						
						rateinventory(needhelp);
					} else {
						p.sendMessage(main.prefix + "Du bist in keinem Support-Chat!");
					}
				}
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				if(p.hasPermission("supportchat.list")) {
					p.sendMessage(main.prefix + "Folgende Spieler brauchen Hilfe: ");
					
					for(Player request : Bukkit.getOnlinePlayers()) {
						if(inrequest.contains(request.getName())) {
							p.sendMessage(ChatColor.RED + request.getName());
						}
					}
				}
			}
			
			
		}
		
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("join")) {
				if(p.hasPermission(main.prefix + "supportchat.join")) {
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null) {
						if(inrequest.contains(target.getName())) {
							p.sendMessage(main.prefix + "Du hast den Support-Chat mit " + target.getName() + " gestartet!");
							target.sendMessage(main.prefix + "Du bist mit " + p.getName() + " nun im Support-Chat!");
							
							supporting.put(p, target);
							gettingsupport.put(target, p);
							
							insupport.add(p.getName());
							insupport.add(target.getName());
							
							inrequest.remove(target.getName());
							
						} else {
							p.sendMessage(main.prefix + "Dieser Spieler braucht keine Hilfe!");
						}
					} else {
						p.sendMessage(main.prefix + "Fehler: Spieler nicht online!");
					}
				}
			}
		}
		
		return true;
	}
	
	
	
	public void rateinventory(Player noob) {
		Inventory bewertung = Bukkit.createInventory(null, 27, "Bewerte deinen Helfer!");
		
		
		ItemStack fenster = new ItemStack(Material.THIN_GLASS, 1, (byte) 15);
		ItemStack wert1 = new ItemStack(Material.WOOL, 1, (byte) 7);
		ItemStack wert2 = new ItemStack(Material.WOOL, 1, (byte) 8);
		ItemStack wert3 = new ItemStack(Material.WOOL, 1, (byte) 11);
		ItemStack wert4 = new ItemStack(Material.WOOL, 1, (byte) 9);
		ItemStack wert5 = new ItemStack(Material.WOOL, 1, (byte) 1);
		ItemStack wert6 = new ItemStack(Material.WOOL, 1, (byte) 4);
		ItemStack wert7 = new ItemStack(Material.WOOL, 1, (byte) 5);
		ItemStack wert8 = new ItemStack(Material.WOOL, 1, (byte) 10);
		ItemStack wert9 = new ItemStack(Material.WOOL, 1, (byte) 2);
		
		
		
		
		ItemMeta meta = fenster.getItemMeta();
		meta.setDisplayName(" ");
		fenster.setItemMeta(meta);
		
		ItemMeta meta1 = wert1.getItemMeta();
		meta1.setDisplayName("§8Sehr Schlecht!");
		wert1.setItemMeta(meta1);
		
		ItemMeta meta2 = wert2.getItemMeta();
		meta2.setDisplayName("§7Schlecht!");
		wert2.setItemMeta(meta2);
		
		ItemMeta meta3 = wert3.getItemMeta();
		meta3.setDisplayName("§3Meeeehh!");
		wert3.setItemMeta(meta3);
		
		ItemMeta meta4 = wert4.getItemMeta();
		meta4.setDisplayName("§2Naja...");
		wert4.setItemMeta(meta4);
		
		ItemMeta meta5 = wert5.getItemMeta();
		meta5.setDisplayName("§4Hmmm...");
		wert5.setItemMeta(meta5);
		
		ItemMeta meta6 = wert6.getItemMeta();
		meta6.setDisplayName("§cJoaaaa");
		wert6.setItemMeta(meta6);
		
		ItemMeta meta7 = wert7.getItemMeta();
		meta7.setDisplayName(ChatColor.YELLOW + "Ganz OK :)");
		wert7.setItemMeta(meta7);
		
		ItemMeta meta8 = wert8.getItemMeta();
		meta8.setDisplayName("§eGut :)");
		wert8.setItemMeta(meta8);
		
		ItemMeta meta9 = wert9.getItemMeta();
		meta9.setDisplayName("§6Sehr Gut!1111Elf");
		wert9.setItemMeta(meta9);
		
		
		
		bewertung.setItem(0, fenster);
		bewertung.setItem(1, fenster);
		bewertung.setItem(2, fenster);
		bewertung.setItem(3, fenster);
		bewertung.setItem(4, fenster);
		bewertung.setItem(5, fenster);
		bewertung.setItem(6, fenster);
		bewertung.setItem(7, fenster);
		bewertung.setItem(8, fenster);
		
		bewertung.setItem(9, wert1);
		bewertung.setItem(10, wert2);
		bewertung.setItem(11, wert3);
		bewertung.setItem(12, wert4);
		bewertung.setItem(13, wert5);
		bewertung.setItem(14, wert6);
		bewertung.setItem(15, wert7);
		bewertung.setItem(16, wert8);
		bewertung.setItem(17, wert9);
		
		bewertung.setItem(18, fenster);
		bewertung.setItem(19, fenster);
		bewertung.setItem(20, fenster);
		bewertung.setItem(21, fenster);
		bewertung.setItem(22, fenster);
		bewertung.setItem(23, fenster);
		bewertung.setItem(24, fenster);
		bewertung.setItem(25, fenster);
		bewertung.setItem(26, fenster);
		
		
		
		noob.openInventory(bewertung);
		
		inbewertung.add(noob.getName());
		
		
		
	}
	
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onclose(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if(inbewertung.contains(p.getName())) {
			p.sendMessage(main.prefix + "Naja... Es ist auch keine Pflicht!");
			inbewertung.remove(p.getName());
		}
		
	}
	

}
