@Table(
        name = "product_serial_group_mask",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "mask"),
                @UniqueConstraint(columnNames = "group")
        }
)