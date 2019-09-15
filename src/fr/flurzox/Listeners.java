package fr.flurzox;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

    private Main main;
    public Listeners(Main main){
        this.main = main;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.getItemInHand().getItemMeta() != null) {
            if (player.getItemInHand().getItemMeta().getDisplayName() != null) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Farmtool")) {
                    if (e.getBlock().getType().equals(Material.CROPS) && e.getBlock().getData() == 7) {
                        boolean seed = false;
                        for (int i = 0; i != 48; i++) {
                            if(player.getInventory().getItem(i) == null){
                                return;
                            }
                            if (player.getInventory().getItem(i).getType().equals(Material.SEEDS)) {
                                seed = true;
                                player.getInventory().setItem(i, new ItemStack(Material.AIR));
                                break;
                            }
                        }
                        if (seed == true) {
                            e.setCancelled(true);
                            player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.WHEAT));
                            player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.SEEDS));
                            e.getBlock().setType(Material.CROPS);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().setItemInHand(main.ee);
    }
}
