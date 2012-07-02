package com.emericask8ur.VoxelaBounty;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	
	public void onDisable(){
		
	}
	
	public void onEnable(){
		
	}
	
	public static boolean has(Player player, String node){
		if(VoxelaBounty.x(player, node)){
			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission!");
			return false;
		}
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		Player player = (Player)sender;
		String playername = player.getName();
		if(cmdLabel.equalsIgnoreCase("b")){
			if(args.length==0){
			VoxelaBounty.Menu_1(sender);
			} //end menu
			
			else if (args.length==1){
			if(args[0].equalsIgnoreCase("hunt") && has(player, "hunt")){
				if(!VoxelaBounty.isHunter(playername)){
				VoxelaBounty.setHunter(playername);
				sender.sendMessage(ChatColor.GOLD + "You are now a Bounty Hunter! " + ChatColor.RED +  "☠");
				VoxelaBounty.Menu_1(sender);
				} else {
					sender.sendMessage(ChatColor.RED + "You are already a Bounty Hunter!");
				}
			}//end /b Hunt <Becomes a Hunter> === More COmmands
			else if (args[0].equalsIgnoreCase("list") && has(player, "list")){
				//TODO: List
				
				
			}//end list
			else if (args[0].equalsIgnoreCase("retire") && has(player, "retire")){
				if(VoxelaBounty.isHunter(playername)){
					VoxelaBounty.removeHunter(playername);
					sender.sendMessage(ChatColor.GOLD + "You are no longer a bounty hunter!");
				} else {
					sender.sendMessage(ChatColor.RED + "You aren't a bounty hunter!");
				}
			}//end retire
			
				
			}//end 1
			else if (args.length==2){
				if(args[0].equalsIgnoreCase("show") && has(player, "show")){
					ItemStack i = new ItemStack(Material.COMPASS,1);
					player.setItemInHand(i);
					Player p = this.getServer().getPlayer(args[1]);
					if(p == null){
						sender.sendMessage(ChatColor.RED + "Player not found!");
					}
					player.setCompassTarget(p.getLocation());
					sender.sendMessage(ChatColor.GOLD + "Compass Target set to: " + p.getName() + " ✖");
					
				}//end show
				
				
				
			}//end 2
			return true;
		}//end b
		return true;
	}

}
