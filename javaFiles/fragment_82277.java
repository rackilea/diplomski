Voucher(id, other attributes) // doesn't change from what you have now
Customer (id, other attributes) // doesn't change except for many-to-many; see below
UsedVoucher(id,
 voucher, // what Voucher was used by that customer
 customer, // what Customer has used that voucher
 changed voucher attributes, // if any
 additional attributes // if needed, such as date/time when voucher was used
)