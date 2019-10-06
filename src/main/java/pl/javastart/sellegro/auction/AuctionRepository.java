package pl.javastart.sellegro.auction;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAll();


    List<Auction> findAllByCarMakerContaining(@Param ("carMaker") String carMaker);

    List<Auction> findByOrderByColor();
    List<Auction> findByOrderByPrice();
    List<Auction> findByOrderByCarModel();
    List<Auction> findByOrderByEndDate();
    List<Auction> findByColorContainingAndCarModelContainingAndCarMakerContaining(String color, String carModel, String carMaker);


}


