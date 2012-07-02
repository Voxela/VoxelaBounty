package com.emericask8ur.VoxelaBounty;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class VoxelaBounty {
	
	/**
	 * Checks if a player has a Voxela Permission Node
	 * @param sender
	 * @param node
	 * @return
	 */
	public static boolean x(CommandSender sender, String node){
		if(sender.hasPermission("VoxelaBounty." + node)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Bounty Access HashSet
	 */
	private static HashSet<String> hunter = new HashSet<String>();
	
	/**
	 * Victim Access HashSet
	 */
	private static HashSet<String> victim = new HashSet<String>();
	
	/**
	 * Checks if a Player is Wanted
	 * @param string
	 * @return
	 */
	public static boolean isWanted(String playerName){
		if(victim.contains(playerName)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets a Player Wanted
	 * @param string
	 */
	public static void setWanted(String playerName){
		victim.add(playerName);
	}	
	
	/**
	 * Checks if a player is a Bounty Hunter
	 * @param string
	 * @return
	 */
	public static boolean isHunter(String playerName){
		if(hunter.contains(playerName)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets a Hunter
	 * @param string
	 */
	public static void setHunter(String playerName){
		hunter.add(playerName);
	}
	
	/**
	 * Removes a Hunter
	 * @param string
	 */
	public static void removeHunter(String playerName){
		hunter.remove(playerName);
	}
	
	
	static ChatColor red = ChatColor.RED;
	static ChatColor gold = ChatColor.GOLD;
	static ChatColor cyan = ChatColor.AQUA;
	static ChatColor gray = ChatColor.GRAY;
	public static void Menu_1(CommandSender sender){
		String playerName = sender.getName();
		sender.sendMessage(red + "✪" + gold + "---------" + cyan + "VoxelaBounty" + gold + "---------" + red + "✪");
		if(isHunter(playerName)){
			sender.sendMessage(gold + "Hunter: " + ChatColor.GREEN + "True");
		}
		if(x(sender, "hunt") && !isHunter(sender.getName())){
			sender.sendMessage(gray + "/B Hunt - " + gold + "Become a bounty hunter");
		}
		if(x(sender, "retire") && isHunter(sender.getName())){
			sender.sendMessage(gray + "/B Retire - " + gold + "Retire as a bounty hunter");
		}
		if(x(sender, "set") && isHunter(sender.getName())){
			sender.sendMessage(gray + "/B Set [Player] [Price] - " + gold  + "Sets a bounty on a player");
		}
		if(x(sender, "list") && isHunter(sender.getName())){
			sender.sendMessage(gray + "/B List - " + gold + "Lists all players wanted");
		}
		if(x(sender, "show") && isHunter(sender.getName())){
			sender.sendMessage(gray + "/B Show [Player] - " + gold + "Shows a player location on compass");
		}
	}

}
