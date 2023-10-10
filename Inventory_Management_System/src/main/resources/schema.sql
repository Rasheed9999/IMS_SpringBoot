
CREATE TABLE `inventory` (
  `ItemID` bigint NOT NULL,
  `Item_Name` varchar(255) DEFAULT NULL,
  `Reorder_Threshold` bigint NOT NULL,
  `Quantity_Available` bigint NOT NULL,
  PRIMARY KEY (`ItemID`)
) ;

CREATE TABLE `login` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ;


CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `local_date` date DEFAULT NULL,
  `local_time` time DEFAULT NULL,
  `item_id` bigint NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `order_quantity` bigint NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
);


CREATE TABLE `users` (
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOt NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ;


