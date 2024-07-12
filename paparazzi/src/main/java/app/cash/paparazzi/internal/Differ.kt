package app.cash.paparazzi.internal

import java.awt.image.BufferedImage

internal interface Differ {
  fun compare(expected: BufferedImage, actual: BufferedImage): DiffResult

  sealed interface DiffResult {
    data class Identical(
      val delta: BufferedImage
    ) : DiffResult

    data class Different(
      val delta: BufferedImage,
      val percentDifference: Float
    ) : DiffResult
  }
}
