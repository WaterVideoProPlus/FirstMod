package com.AlanMiller.firstmod.datagen;

import com.AlanMiller.firstmod.FirstMod;
import com.AlanMiller.firstmod.item.ModCreativeModTabs;
import com.AlanMiller.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output,String locale) {
        super(output, FirstMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.SAPPHIRE.get(),"Sapphire");
        add(ModCreativeModTabs.FIRST_TAB_STRING,"FirstMod");
    }



}