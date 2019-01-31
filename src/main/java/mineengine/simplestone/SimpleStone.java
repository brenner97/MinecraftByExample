package mineengine.simplestone;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * User: The Grey Ghost
 * Date: 24/12/2014
 * <p>
 * simplestone is a ordinary solid cube with the six faces numbered from 0 - 5.
 * For background information on blocks see here http://greyminecraftcoder.blogspot.com.au/2014/12/blocks-18.html
 * <p>
 * For a couple of the methods below the Forge guys have marked it as deprecated.  But you still need to override those
 * "deprecated" block methods.  What they mean is "when you want to find out if a block is (eg) isOpaqueCube(),
 * don't call block.isOpaqueCube(), call iBlockState.isOpaqueCube() instead".
 * If that doesn't make sense to you yet, don't worry.  Just ignore the "deprecated method" warning.
 */
public class SimpleStone extends Block {
    public SimpleStone() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        //How long it took to break
        this.setHardness(1.0F);
        // How bright it will max 10;
        this.setLightLevel(10F);

        /* level Harvest level:
         *     Wood:    0
         *     Stone:   1
         *     Iron:    2
         *     Diamond: 3
         *     Gold:    0
         */
        this.setHarvestLevel("pickaxe", 0);


        //  Dont register here some essential things like
        //      new ModelResourceLocation("mineEngine:simplestone", "inventory");
        //      final int DEFAULT_ITEM_SUBTYPE = 0;
        //      ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
        //  This are setted in the proxy class

        //  Also
        //      simpleStone = (SimpleStone)(new SimpleStone().setUnlocalizedName("simplestone"));
        //      simpleStone.setRegistryName("simplestone");
        //      ForgeRegistries.BLOCKS.register(simpleStone);
        //
        //      // We also need to create and register an ItemBlock for this block otherwise it won't appear in the inventory
        //      itemBlockSimple = new ItemBlock(simpleStone);
        //      itemBlockSimple.setRegistryName(simpleStone.getRegistryName());
        //      ForgeRegistries.ITEMS.register(itemBlockSimple);
        //  Dont register that ones because that all should be registraded by the proxy

    }

    //Set Here which Item will be dropped
    // Random if you need some more change drop
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
