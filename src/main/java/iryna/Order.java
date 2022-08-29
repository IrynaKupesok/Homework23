package iryna;

import lombok.*;

@Getter
    @Setter
    @NoArgsConstructor
    @ToString
@EqualsAndHashCode
    public class Order {
        private Long id;
        private Long petId;
        private int quantity;
        private String shipDate;

    }

