package com.AlanMiller.firstmod.datagen;

import com.AlanMiller.firstmod.FirstMod;
import com.AlanMiller.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemModes extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public ItemModes(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(i -> FirstMod.MOD_ID.equals(ForgeRegistries.ITEMS.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        itemGeneratedModel(ModItems.SAPPHIRE.get(), resourceItem(itemName(ModItems.SAPPHIRE.get())));
        items.remove(ModItems.SAPPHIRE.get());

    }



    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }


    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FirstMod.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(FirstMod.MOD_ID, "item/" + path);
    }

}