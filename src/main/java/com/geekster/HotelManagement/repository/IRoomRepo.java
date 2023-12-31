package com.geekster.HotelManagement.repository;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepo extends CrudRepository<HotelRoom,Long> {

    List<HotelRoom> findByRoomStatus(Boolean roomStatus);
    List<HotelRoom> findByRoomStatusAndRoomType(Boolean status, Type type);
    List<HotelRoom>findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(Boolean status, Type type,Double lLimit,Double uLimit);
    List<HotelRoom> findByRoomTypeOrderByRoomPriceDesc(Type type);

    List<HotelRoom> findByRoomTypeAndRoomPriceBetweenOrRoomType(Type type1,Double lLimit,Double uLimit,Type type2);
}
