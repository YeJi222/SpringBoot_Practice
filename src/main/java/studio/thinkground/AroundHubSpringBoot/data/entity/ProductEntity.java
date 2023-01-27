package studio.thinkground.AroundHubSpringBoot.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import studio.thinkground.AroundHubSpringBoot.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product") // entity를 기반으로 database에 'product'라는 이름의 테이블을 자동으로 생성
public class ProductEntity extends BaseEntity{

    @Id // primary key
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

  /*
  @Column
  String sellerId;
  @Column
  String sellerPhoneNumber;
   */

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}