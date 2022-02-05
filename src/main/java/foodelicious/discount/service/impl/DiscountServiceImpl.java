package foodelicious.discount.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import foodelicious.discount.model.DiscountBean;
import foodelicious.discount.repository.DiscountRepository;
import foodelicious.discount.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

	DiscountRepository discountRepository;

	public DiscountServiceImpl(DiscountRepository discountRepository) {
		super();
		this.discountRepository = discountRepository;
	}

	@Override
	public DiscountBean insertItem(DiscountBean discountBean) {
		return discountRepository.save(discountBean);
	}

	@Override
	public void deleteItem(Long discountId) {
		discountRepository.deleteById(discountId);
	}

	@Override
	public List<DiscountBean> selectItem(Long memberId) {
		return discountRepository.findAllByMemberId(memberId);
	}

}
