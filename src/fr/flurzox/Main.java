package fr.flurzox;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Main extends JavaPlugin {
    public ItemStack ee = new ItemStack(Material.DIAMOND_HOE);
    ItemMeta eee = ee.getItemMeta();
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listeners(this), this);
        eee.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        eee.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        eee.setDisplayName("§6Farmtool");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§6Farmtool");
        eee.setLore(lore);
        ee.setItemMeta(eee);
    }
}
