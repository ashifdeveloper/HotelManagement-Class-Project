package com.geekster.HotelManagement.service;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    IRoomRepo roomRepo;

    public Iterable<HotelRoom> getAllRooms() {
        return roomRepo.findAll();
    }

    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "Added";
    }

    public String addMultipleRoom(List<HotelRoom> rooms) {
         roomRepo.saveAll(rooms);
         return "Added "+rooms;
    }

    public HotelRoom getRoomById(Long id) {
        Optional<HotelRoom> optionalHotelRoom =roomRepo.findById(id);
        if(optionalHotelRoom.isEmpty()){
            return null;
        }
        return optionalHotelRoom.get();
    }

    public Boolean isRoomExist(Long id) {
        return roomRepo.existsById(id);
    }

    public Long getRoomCount() {
        return roomRepo.count();
    }

    public String updateRoomById(Long id, Type type) {
        Optional<HotelRoom> myRoomOpt = roomRepo.findById(id);
        HotelRoom myRoom = null;
        if(myRoomOpt.isPresent()){
            myRoom = myRoomOpt.get();
        }
        else{
            return "Id Not Found";
        }
        myRoom.setRoomType(type);
        roomRepo.save(myRoom);
        return "Room Type Updated";
    }

    public List<HotelRoom> getRoomsByStatus(Boolean status) {
        return roomRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomsByStatusAndType(Boolean status, Type type) {
        return roomRepo.findByRoomStatusAndRoomType(status,type);
    }

    public List<HotelRoom> getRoomByStatusAndTypeAndPrice(Boolean status, Type type, Double lLimit, Double uLimit) {
        return roomRepo.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(status,type,lLimit,uLimit);
    }

    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(Type roomType) {
        return roomRepo.findByRoomTypeOrderByRoomPriceDesc(roomType);
    }

    public List<HotelRoom> getBudgetedAcOrNonAc(Type roomType1, Double lLimit, Double uLimit,Type roomType2) {
        return roomRepo.findByRoomTypeAndRoomPriceBetweenOrRoomType(roomType1,lLimit,uLimit,roomType2);
    }
}
