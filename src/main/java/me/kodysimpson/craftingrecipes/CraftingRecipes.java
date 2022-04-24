package me.kodysimpson.craftingrecipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.List;

public final class CraftingRecipes extends JavaPlugin {

    @Override
    public void onEnable() {

        ItemStack superPotato = new ItemStack(Material.POISONOUS_POTATO, 1);
        ItemMeta superPotatoMeta = superPotato.getItemMeta();
        superPotatoMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Super Potato!");
        superPotatoMeta.setLore(List.of("This potato will ", "give you superpowers."));
        superPotato.setItemMeta(superPotatoMeta);

        //Super Potato
        {
            NamespacedKey key = new NamespacedKey(this, "superpotato");
            ShapedRecipe recipe = new ShapedRecipe(key, superPotato);
            recipe.shape(
                    " X ",
                    " X ",
                    " X ");
            recipe.setIngredient('X', Material.POTATO);

            Bukkit.addRecipe(recipe);
        }

        //Super Duper Potato
        {
            NamespacedKey key = new NamespacedKey(this, "superduperpotato");
            ItemStack superDuperPotato = new ItemStack(Material.POISONOUS_POTATO, 1);
            ItemMeta superDuperPotatoItemMeta = superDuperPotato.getItemMeta();
            superDuperPotatoItemMeta.addEnchant(Enchantment.CHANNELING, 1, false);
            superDuperPotatoItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Super Duper Potato!");
            superDuperPotatoItemMeta.setLore(List.of("This potato will ", "give you superduperpowers.", "emily steps on a lego."));
            superDuperPotato.setItemMeta(superDuperPotatoItemMeta);

            ShapedRecipe recipe = new ShapedRecipe(key, superDuperPotato);
            recipe.shape(
                    "SKS",
                    "SKS",
                    "SKS");
            recipe.setIngredient('K', new RecipeChoice.MaterialChoice.ExactChoice(superPotato));
            recipe.setIngredient('S', Material.POTATO);

            Bukkit.addRecipe(recipe);
        }

        {
            ItemStack spice = new ItemStack(Material.GLOWSTONE_DUST);
            FurnaceRecipe furnaceRecipe = new FurnaceRecipe(new NamespacedKey(this, "beep"), spice, Material.RED_SAND, 1.0f, 100);
            Bukkit.addRecipe(furnaceRecipe);
        }

        {
            ItemStack potatoArmor = new ItemStack(Material.CHAINMAIL_HELMET, 1);
            ItemMeta potatoArmorMeta = potatoArmor.getItemMeta();
            potatoArmorMeta.setDisplayName(ChatColor.RED + "Helmet of Potato");
            potatoArmor.setItemMeta(potatoArmorMeta);

            SmithingRecipe smithingRecipe = new SmithingRecipe(new NamespacedKey(this, "yomomma"), potatoArmor, new RecipeChoice.MaterialChoice(Material.CHAINMAIL_HELMET), new RecipeChoice.ExactChoice(superPotato));
            Bukkit.addRecipe(smithingRecipe);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
