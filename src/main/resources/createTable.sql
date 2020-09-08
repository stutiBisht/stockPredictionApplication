CREATE TABLE DOW_JONES_INDEX_DATA (
			quarter INT NOT NULL,
			stock VARCHAR ( 25 ) NOT NULL,
			open_price money NOT NULL,
			high money NOT NULL,
			low money NOT NULL,
			close_price money NOT NULL,
			volume numeric NOT NULL,
			percent_change_price numeric(7,6) NOT NULL,
			percent_change_volume_over_last_wk numeric(10,8) NULL,
			previous_weeks_volume numeric NULL,
			next_weeks_open money NOT NULL,
			next_weeks_close money NOT NULL,
			percent_change_next_weeks_price numeric(7,6)NOT NULL,
			days_to_next_dividend INT NOT NULL,
			percent_return_next_dividend numeric(7,6) NOT NULL,
			close_date DATE NOT NULL,
			unique (stock, close_date)
			);