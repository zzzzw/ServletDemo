/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-08-14 08:28:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `x_order`
-- ----------------------------
DROP TABLE IF EXISTS `x_order`;
CREATE TABLE `x_order` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `starttime` date default NULL,
  `price` float(10,3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_order
-- ----------------------------
INSERT INTO `x_order` VALUES ('4', 'aaaa', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('5', 'zhangsan', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('6', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('7', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('8', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('10', '张三', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('14', '张三', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('15', 'liming', '2015-09-09', '12.365');
INSERT INTO `x_order` VALUES ('16', '张阿三', '2015-08-10', '15.000');
INSERT INTO `x_order` VALUES ('17', '张思', '2015-08-10', '12.365');
