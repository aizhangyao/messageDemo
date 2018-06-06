/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : db_zy

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-05-28 16:47:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_orders`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `id` int(11) NOT NULL DEFAULT '0',
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
INSERT INTO `tb_orders` VALUES ('1', '0');
INSERT INTO `tb_orders` VALUES ('2', '0');
INSERT INTO `tb_orders` VALUES ('3', '0');
INSERT INTO `tb_orders` VALUES ('4', '0');
INSERT INTO `tb_orders` VALUES ('5', '0');
