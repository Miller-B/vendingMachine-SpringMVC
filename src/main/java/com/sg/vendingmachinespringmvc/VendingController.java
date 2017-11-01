/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc;

import com.sg.vendingmachinespringmvc.dao.ItemListDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachineServiceLayer;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BMMil
 */
//This annotation lets Spring know that this class is a controller component
@Controller
public class VendingController {
    
    VendingMachineServiceLayer service;
    //BigDecimal moneyIn = new BigDecimal(0.00);
    
    
    @Inject
    public VendingController(ItemListDao dao, VendingMachineServiceLayer service) {
               this.service = service;
    }
    
    //@RM is the annotation that tells Spring MVC framework to call this method when this web request (specified by "value") is recieved
    @RequestMapping(value="/", method=RequestMethod.GET) //HTTP Verb "GET" gets the resource from the web server
    public String displayItems(Model model, @RequestParam(value = "displayChange", required = false) boolean displayChange) {
        List<Item> itemsList = service.getAllItems();
        //putting the list of items onto the map called model so they can be passed to the jsp to be displayed
       model.addAttribute("itemsList", itemsList);// JSP will use Expression Language(EL) mechanism ${...} to access request attribute
     
//       BigDecimal moneyIn = service.getTotalMoney();
//       model.addAttribute("moneyIn", moneyIn);
//        
       Integer selectedItem = service.getItemChoice();
       model.addAttribute("selectedItem", selectedItem);
       
       if (displayChange == true) {
       //moneyIn = service.getTotalMoney();
       //model.addAttribute("moneyIn", moneyIn);
       
       Change change = service.returnChange();
       model.addAttribute("change", change);
       
       service.zeroBalance();
       
       
       selectedItem = service.getItemChoice();
       model.addAttribute("selectedItem", selectedItem);
       }
       //Item item = service.getItemById(itemId);
       //model.addAttribute("itemId", itemId);
       //tell Spring which view component we want to use by returning the logical name ("index)
       BigDecimal moneyIn = service.getTotalMoney();
       model.addAttribute("moneyIn", moneyIn);
       model.addAttribute("displayChange", displayChange);
       return "index";
    }
    

//     @RequestMapping(value="/selectItem/{itemId}", method=RequestMethod.GET)
//    public String selectItem(@PathVariable("itemId") Integer itemId) {
//        service.getItemById(itemId);
//        return "redirect:/";
//    }
    
     @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public String addMoney(HttpServletRequest request, Model model) {
      String moneyIn  = request.getParameter("money");
       service.addMoney(moneyIn);
       //Change change = service.returnChange(service.getTotalMoney());
       //model.addAttribute("change", change);
       return "redirect:/";


    }
    
   @RequestMapping(value="/getItemById", method = RequestMethod.GET)
   public String getItemById(HttpServletRequest request, Model model) {
       String selection = request.getParameter("selection");     
        Integer itemId = Integer.parseInt(selection);
        service.setItemChoice(itemId);
        
        return "redirect:/";
       
   }
   
       @RequestMapping(value = "/purchaseItem", method = RequestMethod.GET)
    public String purchaseItem(HttpServletRequest request, Model model) {
       
        Integer itemId = Integer.parseInt(request.getParameter("selectedItem"));
        
           System.out.println("Hey you made it");
//        itemChoice = service.getItemById(itemId);
        service.purchaseItem(itemId);
//  
//   
        return "redirect:/?displayChange=true";
   }
   
   @RequestMapping(value="/returnChange", method = RequestMethod.POST)
   public String returnChange (HttpServletRequest request, Model model) {
     service.returnChange();
       return "redirect:/?displayChange=true";
   }
   
   @RequestMapping(value="/selectItemId", method = RequestMethod.GET)
   public String selectItemId (HttpServletRequest request, Model model) {
       Integer itemId = Integer.parseInt(request.getParameter("itemId"));
       service.setItemChoice(itemId);
       return "redirect:/";       
   }
   
   //    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
//    public String addMoney(HttpServletRequest request, Model model) {
//        String button = request.getParameter("money");
//
//        if (button.equals("Add Dollar")) {
//            moneyIn = moneyIn.add(new BigDecimal(1.00));
//        }
//        if (button.equals("quarter")) {
//            moneyIn.add(new BigDecimal(0.25));
//        }
//        if (button.equals("dime")) {
//            moneyIn.add(new BigDecimal(0.10));
//        }
//        if (button.equals("nickel")) {
//            moneyIn.add(new BigDecimal(0.05));
//        }
//model.addAttribute("moneyIn", moneyIn);
//        return "redirect:/";
//    }    
    
//    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
//    public String addMoney(HttpServletRequest request, Model model) {
//        String money = request.getParameter("money-button");
//        
//     
//        service.addMoney(money);
//       
//        model.addAttribute("moneyIn", money);

//        if (button.equals("dollar")) {
//            //service.addDollar(moneyIn);
//           service.addDollar(moneyIn);
//        }
//        if (button.equals("quarter")) {
//            service.addQuarter(moneyIn);
//        }
//        if (button.equals("dime")) {
//            service.addDime(moneyIn);
//        }
//        if (button.equals("nickel")) {
//            service.addNickel(moneyIn);
//        }
//
//        return "redirect:/";
//    }
    

}

// @Inject
//    public VendingMachineController(VendingMachineSpringMVCServiceLayer service) {
//        this.service = service;
//    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model, @RequestParam(value = "displayChange", required = false) boolean displayChange) {
//        List<Item> itemList = service.getAllItems();
//        model.addAttribute("itemList", itemList);
//        String message = service.getMessage();
//        model.addAttribute("message", message);
//        BigDecimal balance = service.getBalance();
//        model.addAttribute("balance", balance);
//        Integer itemIdToBuy = service.getItemIdToBuy();
//        model.addAttribute("itemIdToBuy", itemIdToBuy);
//        if (displayChange == true) {
//            Change change = service.returnMoney();
//            model.addAttribute("change", change);
//            balance = service.getBalance();
//            model.addAttribute("balance", balance);
//            itemIdToBuy = service.getItemIdToBuy();
//            model.addAttribute("itemIdToBuy", itemIdToBuy);
//        }
//        
//        model.addAttribute("displayChange", displayChange);
//        return "index";
//    }
//    @RequestMapping(value = "/selectItem", method = RequestMethod.GET)
//    public String selectItem(HttpServletRequest request) {
//        String itemIdToBuyString = request.getParameter("itemIdToBuy");
//        Integer itemIdToBuy = Integer.parseInt(itemIdToBuyString);
//        service.setItemIdToBuy(itemIdToBuy);
//        service.setMessage(null);
//        return "redirect:/";
//    }
//    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
//    public String addMoney(HttpServletRequest request, Model model) {
//        String money = request.getParameter("money");
//        service.addMoney(money);
//        Change change = service.getChange(service.getBalance());
//        model.addAttribute("change", change);
//        return "redirect:/";
//    }
//    @RequestMapping(value = "/returnMoney", method = RequestMethod.POST)
//    public String returnMoney(Model model) {
//        service.setMessage(null);
//        return "redirect:/?displayChange=true";
//    }
//    @RequestMapping(value = "/purchaseItem", method = RequestMethod.GET)
//    public String purchaseItem(Model model) {
//        service.purchaseItem();
//        String purchaseMessage = service.getMessage();
//        String display = "false";
//        if(purchaseMessage.equalsIgnoreCase("Thank you for your purchase.")) {
//            display = "true";
//        }
//        return "redirect:/?displayChange=" + display;
//    }


