package dogged.grapple.utilities;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class ItemMaker {
    public static ItemStack buildItem(Material type, String displayName) {
        ItemStack result = new ItemStack(type);
        ItemMeta resultMeta = result.getItemMeta();
        resultMeta.displayName(Component.text(displayName));
        result.setItemMeta(resultMeta);

        return result;
    }

    public static ItemStack buildItem(Material type, String displayName, List<Component> lore) {
        ItemStack result = new ItemStack(type);
        ItemMeta resultMeta = result.getItemMeta();
        resultMeta.displayName(Component.text(displayName));
        resultMeta.lore(lore);
        result.setItemMeta(resultMeta);

        return result;
    }

    public static ItemStack buildItem(Material type, String displayName, Map<Enchantment, Integer> enchants) {
        ItemStack result = new ItemStack(type);
        ItemMeta resultMeta = result.getItemMeta();
        resultMeta.displayName(Component.text(displayName));

        for (Enchantment enchantment : enchants.keySet()) {
            resultMeta.addEnchant(enchantment, enchants.get(enchantment), true);
        }

        result.setItemMeta(resultMeta);

        return result;
    }

    public static ItemStack buildItem(Material type, String displayName, List<Component> lore, Map<Enchantment, Integer> enchants) {
        ItemStack result = new ItemStack(type);
        ItemMeta resultMeta = result.getItemMeta();
        resultMeta.displayName(Component.text(displayName));
        resultMeta.lore(lore);

        for (Enchantment enchantment : enchants.keySet()) {
            resultMeta.addEnchant(enchantment, enchants.get(enchantment), true);
        }

        result.setItemMeta(resultMeta);

        return result;
    }
}
