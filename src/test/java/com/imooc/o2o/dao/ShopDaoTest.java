package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	// 注入DAO
	@Autowired
	private ShopDao shopDao;

	// 测试方法
	@Test
	@Ignore
	public void testInsertShop() {
		// 引入实体类 店铺
		Shop shop = new Shop();
		// 引入实体类 用户信息
		PersonInfo owner = new PersonInfo();
		// 引入实体类 区域
		Area area = new Area();
		// 引入实体类 商品类别
		ShopCategory shopCategory = new ShopCategory();

		// 设置实体类参数
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");

		// 调用DAO层方法
		int effectedNum = shopDao.insertShop(shop);
		// 断言方法
		assertEquals(1, effectedNum);
	}

	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("update测试描述");
		shop.setShopAddr("update测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
