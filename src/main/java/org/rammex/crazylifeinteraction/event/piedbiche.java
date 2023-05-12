package org.rammex.crazylifeinteraction.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.rammex.crazylifeinteraction.CrazyLifeInteraction;

import java.util.HashSet;

import static java.lang.Thread.sleep;
import static org.bukkit.Bukkit.getServer;

public class piedbiche implements Listener {

    private final CrazyLifeInteraction plugin;
    public boolean isopen = false;


    public piedbiche() {
        this.plugin = plugin;
    }


    @EventHandler
    public void GoldInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();

        if(block == null) return;
        if(block.getType() == Material.GREEN_CANDLE){
            ItemStack hoe = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta customM = hoe.getItemMeta();
            customM.setDisplayName(ChatColor.YELLOW+"Lingot d'or");
            hoe.setItemMeta(customM);
            player.getInventory().addItem(hoe);
            player.updateInventory();
            block.setType(Material.AIR);
            player.sendMessage(ChatColor.YELLOW+"Tu as bien ramassé un lingot !");
            getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    block.setType(Material.GREEN_CANDLE);
                }
            }, 10 * 20L);



        }

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        ItemStack it = event.getItem();

        if(it == null) return;
        int min = 1; // Minimum value of range
        int max = 20;



        if(it.getType() == Material.BLAZE_ROD && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§fPied de biche")){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(block.getType() == Material.IRON_DOOR){
                    System.out.print("Crochetage en cours");
                    BlockState blockState = player.getTargetBlock((HashSet) null, 3).getState();
                    Openable openable = (Openable) blockState.getBlockData();
                    if(isopen){
                        openable.setOpen(true);
                        blockState.setBlockData(openable);
                        blockState.update();
                        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
                        if(random_int == 10){
                            it.setType(Material.AIR);
                        }
                        getServer().getScheduler().scheduleAsyncDelayedTask((Plugin) this, new Runnable() {
                            public void run() {
                                openable.setOpen(false);
                            }
                        }, 10 * 20L);
                        isopen = false;



                    }else{
                        crochetagegui1(player);
                    }
                    }
            }
        }


    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        Player player =(Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 1 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui2(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 2 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui3(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 3 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui4(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 4 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui5(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 5 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui6(player);

            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 6 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui7(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 7 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui8(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 8 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui9(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 9 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                crochetagegui10(player);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Crochetage Etape 10 ✯")){
            event.setCancelled(true);
            if(current.getType() == Material.RED_WOOL){
                player.closeInventory();
                player.sendMessage("§4Crochetage Echouée !");
            }

            if(current.getType() == Material.GREEN_WOOL){
                player.closeInventory();
                player.sendMessage("§aCrochetage Réussit !");
                isopen = true;

            }

        }



    }


    public void crochetagegui1(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 1 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui2(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 2 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui3(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 3 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui4(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 4 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.GREEN_WOOL, "§a✚"));
        player.openInventory(inv);
    }
    public void crochetagegui5(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 5 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }

    public void crochetagegui6(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 6 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui7(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 7 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui8(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 8 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }
    public void crochetagegui9(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 9 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.GREEN_WOOL, "§a✚"));
        player.openInventory(inv);
    }
    public void crochetagegui10(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6§l✯ Crochetage Etape 10 ✯");
        inv.setItem(0, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(1, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(2, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(3, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(4, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(5, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(6, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(7, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(8, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(9, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(10, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(11, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(12, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(13, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(14, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(15, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(16, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(17, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(18, getItem(Material.GREEN_WOOL, "§a✚"));
        inv.setItem(19, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(20, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(21, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(22, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(23, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(24, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(25, getItem(Material.RED_WOOL, "§4✚"));
        inv.setItem(26, getItem(Material.RED_WOOL, "§4✚"));
        player.openInventory(inv);
    }

    public ItemStack getItem(Material material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }

}
