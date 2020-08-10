import styled from "styled-components";

export const CarouselWrapper = styled.div`
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;

  margin-top: ${({ theme }) => theme.interval.xl};
  margin-bottom: ${({ theme }) => theme.interval.xl};

  .inner {
    width: 70vw;
  }

  .title {
    font-weight: bold;
    margin: ${({ theme: { margins } }) => margins.small};
    font-size: ${({ theme: { fontSizes } }) => fontSizes.xxxl};
  }

  .carousel_item {
    padding: ${({ theme: { paddings } }) => paddings.small};

    .book_title {
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
      padding: ${({ theme: { paddings } }) => paddings.small};
      font-weight: bold;
      text-align: center;
    }

    .writer {
      text-align: center;
      color: ${({ theme: { colors } }) => colors.gray_2};
    }

    img {
      width: inherit;
      box-shadow: ${({ theme: { boxShadow } }) => boxShadow.boxShadow_1};
      cursor: pointer;
      :hover {
        opacity: 0.7;
      }
    }
  }
`;