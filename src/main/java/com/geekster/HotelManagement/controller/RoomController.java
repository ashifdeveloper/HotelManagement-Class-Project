package com.geekster.HotelManagement.controller;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;
    //Read

    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms(){
        return roomService.getAllRooms();
    }

    //create

    @PostMapping("room")
    public String addRoom(@RequestBody HotelRoom room){
        return roomService.addRoom(room);
    }
    @PostMapping("rooms")
    public String addMultipleRooms(@RequestBody List<HotelRoom> rooms){
        return roomService.addMultipleRoom(rooms);
    }

    @GetMapping("room/{id}")
    public HotelRoom getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @GetMapping("room/{id}/exist")
    public Boolean isRoomExist(@PathVariable Long id){
        return roomService.isRoomExist(id);
    }

    @GetMapping("rooms/count")
    public Long getRoomCount(){
        return roomService.getRoomCount();
    }

    //update room by id

    @PutMapping("room/{id}/{type}")
    public String updateRoomById(@PathVariable Long id,@PathVariable Type type){
        return roomService.updateRoomById(id,type);
    }

    //get room by status

    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status){
        return roomService.getRoomsByStatus(status);
    }

    //All rooms are ac and which are available
    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status,@PathVariable Type type){
        return roomService.getRoomsByStatusAndType(status,type);
    }
    // Available rooms which are AC and have some price range

    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status,@PathVariable Type type,@RequestParam Double lLimit,@RequestParam Double uLimit){
        return roomService.getRoomByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }
//All Rooms which are Ac sorted by price desc
    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable Type roomType){
        return roomService.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

    //Ac and price range or Non-Ac

    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")

    public List<HotelRoom> getBudgetedAcOrNonAc(@PathVariable Type roomType1,@RequestParam Double lLimit,Double uLimit,@PathVariable Type roomType2){
        return roomService.getBudgetedAcOrNonAc(roomType1,lLimit,uLimit,roomType2);
    }




}
