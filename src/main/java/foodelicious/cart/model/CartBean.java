package foodelicious.cart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import foodelicious.member.model.Member;
import foodelicious.product.model.Product;

@Entity
@Table(name = "shopping_cart")
@Component
public class CartBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cartId;

	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "quantity")
	private Integer quantity;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", insertable = false, updatable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	public CartBean() {
		super();
	}

	public CartBean(Long cartId, Long memberId, Long productId, Integer quantity, Member member, Product product) {
		super();
		this.cartId = cartId;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
		this.member = member;
		this.product = product;
	}

	public CartBean(Integer quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartBean [cartId=" + cartId + ", memberId=" + memberId + ", productId=" + productId + ", quantity="
				+ quantity + ", member=" + member + ", product=" + product + "]";
	}

}